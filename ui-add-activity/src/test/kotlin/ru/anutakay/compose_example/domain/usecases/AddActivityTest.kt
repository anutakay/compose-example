package ru.anutakay.compose_example.domain.usecases

import io.reactivex.rxjava3.core.Completable
import org.junit.Test
import org.mockito.Mockito
import ru.anutakay.compose_example.data.entities.Activity
import ru.anutakay.compose_example.data.repositories.activities.ActivitiesRepository
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

internal class AddActivityTest {

    @Test
    fun invoke() {
        val activity = Activity("bbbb", LocalDateTime.now())
        val repository = Mockito.mock(ActivitiesRepository::class.java)
        Mockito.`when`(repository.addActivity(activity)).thenReturn(Completable.fromAction {
            println("start")
            Thread.sleep(500)
            println("ready")
        })

        val testObserver = AddActivityInteractor(repository).invoke(AddActivityInteractor.Params(activity)).test()

        testObserver.await(5, TimeUnit.SECONDS)
        testObserver.values().forEach {
            println("value: $it")
        }
    }
}
