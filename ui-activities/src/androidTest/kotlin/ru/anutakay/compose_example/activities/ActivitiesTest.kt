package ru.anutakay.compose_example.activities

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
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
        composeTestRule.onNodeWithText("first action").assertExists()
        composeTestRule.onNodeWithText("second action").assertExists()
        composeTestRule.onNodeWithText("action").assertExists()
    }
}
