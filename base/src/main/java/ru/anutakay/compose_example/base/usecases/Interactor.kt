package ru.anutakay.compose_example.base.usecases

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import ru.anutakay.compose_example.base.InvokeError
import ru.anutakay.compose_example.base.InvokeStarted
import ru.anutakay.compose_example.base.InvokeStatus
import ru.anutakay.compose_example.base.InvokeSuccess
import java.util.concurrent.TimeUnit

abstract class Interactor<in PARAMS> {
    operator fun invoke(
        params: PARAMS,
        timeoutMillis: Long = defaultTimeoutMills
    ): Observable<InvokeStatus> = Observable.concat(
        Observable.just(InvokeStarted),
        Observable.just(params)
            .concatMap {
                try {
                    doWork(it)
                        .timeout(timeoutMillis, TimeUnit.MILLISECONDS)
                        .andThen(Observable.just(InvokeSuccess))
                } catch (e: Throwable) {
                    Observable.error(e)
                }
            }
    ).onErrorReturn { InvokeError(it) }

    abstract fun doWork(params: PARAMS): Completable

    companion object {
        val defaultTimeoutMills: Long = TimeUnit.SECONDS.toMillis(10)
    }
}
