package ru.anutakay.compose_example.activities

import androidx.compose.ui.test.assertAll
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasAnyChild
import androidx.compose.ui.test.hasAnyDescendant
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.isEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import kotlinx.coroutines.awaitCancellation
import ru.anutakay.compose_example.TestActivity
import ru.anutakay.compose_example.data.ExampleDatabase
import ru.anutakay.compose_example.data.entities.DbActivityNote

@HiltAndroidTest
class ActivitiesTest {

    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    val composeTestRule = createAndroidComposeRule<TestActivity>()

    @Inject
    lateinit var exampleDatabase: ExampleDatabase

    @Before
    fun setup() {
        val testActivity = DbActivityNote().apply {
            title = "first"
            timestamp = 1662606234000
        }
        val testActivity2 = DbActivityNote().apply {
            title = "second"
            timestamp = 1662609834000
        }
        val testActivity3 = DbActivityNote().apply {
            title = "another day"
            timestamp = 1663473834000
        }

        hiltTestRule.inject()

        with(exampleDatabase.activitiesDao()) {
            addActivityNote(testActivity)
            addActivityNote(testActivity2)
            addActivityNote(testActivity3)
        }
    }

    @Test
    fun myTest() {
        composeTestRule.onRoot().assertIsDisplayed()
        composeTestRule.onAllNodesWithTag(ActivitiesTags.LIST)
            .assertCountEquals(1)

       composeTestRule.onAllNodesWithTag(ActivitiesTags.DAY_CARD, useUnmergedTree = true)
            .assertCountEquals(2)
            .assertAll(
                hasParent(hasTestTag(ActivitiesTags.LIST))
                        and hasAnyChild(hasTestTag(ActivitiesTags.DATE))
                        and hasAnyChild(hasTestTag(ActivitiesTags.ACTIVITY_ITEM))
            )


       composeTestRule.onAllNodesWithTag(ActivitiesTags.ACTIVITY_ITEM, useUnmergedTree = true)
            .assertCountEquals(3)
            .assertAll(
                hasParent(hasTestTag(ActivitiesTags.DAY_CARD))
                        and hasAnyChild(hasTestTag(ActivitiesTags.TITLE))
                        and hasAnyChild(hasTestTag(ActivitiesTags.TIME))
            )
    }
}
