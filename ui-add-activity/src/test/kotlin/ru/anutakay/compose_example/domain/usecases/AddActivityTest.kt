package ru.anutakay.compose_example.domain.usecases

import org.junit.Test
import ru.anutakay.compose_example.data.entities.Activity
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

internal class AddActivityTest {

    @Test
    fun invoke() {
        val activity = Activity("bbbb", LocalDateTime.now())
        val testObserver = AddActivity().invoke(AddActivity.Params(activity)).test()

        testObserver.await(5, TimeUnit.SECONDS)
        testObserver.values().forEach {
            println("value: $it")
        }
    }
}
