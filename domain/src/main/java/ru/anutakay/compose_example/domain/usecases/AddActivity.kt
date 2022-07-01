package ru.anutakay.compose_example.domain.usecases

import io.reactivex.rxjava3.core.Completable
import ru.anutakay.compose_example.data.entities.Activity
import ru.anutakay.compose_example.domain.Interactor
import javax.inject.Inject

class AddActivity @Inject constructor() : Interactor<AddActivity.Params>() {

    override fun doWork(params: Params): Completable = Completable.fromAction {
        println("start")
        Thread.sleep(600)
        println("ready")
    }

    data class Params(
        val activity: Activity
    )
}
