package ru.anutakay.compose_example.base.usecases

import io.reactivex.rxjava3.core.Observable

abstract class SimpleObserver<RESULT : Any> {

    val observable: Observable<RESULT>
        get() = createObservable().distinctUntilChanged()

    abstract fun createObservable(): Observable<RESULT>
}
