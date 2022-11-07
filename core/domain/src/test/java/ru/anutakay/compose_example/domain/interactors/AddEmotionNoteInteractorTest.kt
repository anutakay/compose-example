package ru.anutakay.compose_example.domain.interactors

import io.reactivex.rxjava3.core.Completable
import java.time.LocalDateTime
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.whenever
import ru.anutakay.compose_example.base.InvokeStarted
import ru.anutakay.compose_example.base.InvokeSuccess
import ru.anutakay.compose_example.data.repositories.activities.ActivitiesRepository
import ru.anutakay.compose_example.model.entities.Emotion
import ru.anutakay.compose_example.model.entities.EmotionNote

internal class AddEmotionNoteInteractorTest {

    @Test
    fun invoke() {
        val activity = EmotionNote(Emotion.INTERESTS, LocalDateTime.now())
        val testParams = AddEmotionNoteInteractor.Params(activity)

        val repository = Mockito.mock(ActivitiesRepository::class.java)
        whenever(repository.addEmotionNote(activity))
            .thenReturn(Completable.fromAction { Thread.sleep(500) })

        val usecaseUnderTest = AddEmotionNoteInteractor(repository)
        val testObserver = usecaseUnderTest(testParams).test()

        testObserver.awaitCount(2)
            .assertComplete()
            .assertNoErrors()
            .assertValueCount(2)
            .assertValueAt(0, InvokeStarted)
            .assertValueAt(1, InvokeSuccess)
    }
}
