package ru.anutakay.compose_example.activities

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.assertAll
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasAnyChild
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onRoot
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ru.anutakay.compose_example.domain.usecases.ObserveActivitiesByDate
import javax.inject.Inject

@HiltAndroidTest
class ActivitiesTest {

    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    val composeTestRule = createComposeRule()

    @Inject
    lateinit var getActivitiesGroupedByDay: ObserveActivitiesByDate

    private lateinit var viewModel: ActivitiesViewModel

    @Before
    fun setup() {
        hiltTestRule.inject()
        viewModel = ActivitiesViewModel(getActivitiesGroupedByDay)

        composeTestRule.setContent {
            MaterialTheme {
                Activities(viewModel, rememberNavController())
            }
        }
    }

    @Test
    fun myTest() {
        composeTestRule.onRoot().assertIsDisplayed()
        composeTestRule.onAllNodesWithTag(ActivitiesTags.LIST)
            .assertCountEquals(1)

        composeTestRule.onAllNodesWithTag(ActivitiesTags.DAY_CARD)
            .assertCountEquals(2)
            .assertAll(
                hasParent(hasTestTag(ActivitiesTags.LIST))
                        and hasAnyChild(hasTestTag(ActivitiesTags.DATE))
                        and hasAnyChild(hasTestTag(ActivitiesTags.ACTIVITY_ITEM))
            )

        composeTestRule.onAllNodesWithTag(ActivitiesTags.ACTIVITY_ITEM)
            .assertCountEquals(3)
            .assertAll(
                hasParent(hasTestTag(ActivitiesTags.DAY_CARD))
                        and hasAnyChild(hasTestTag(ActivitiesTags.TITLE))
                        and hasAnyChild(hasTestTag(ActivitiesTags.TIME))
            )
    }
}
