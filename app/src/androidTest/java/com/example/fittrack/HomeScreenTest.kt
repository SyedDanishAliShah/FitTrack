package com.example.fittrack

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FitnessUiTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun addActivity_navigatesAndDisplays() {
        composeTestRule.onNodeWithContentDescription("Add Activity").performClick()
        composeTestRule.onNodeWithText("Activity Name").performTextInput("Run")
        composeTestRule.onNodeWithText("Duration (mins)").performTextInput("25")
        composeTestRule.onNodeWithText("Type (e.g., Running)").performTextInput("Running")
        composeTestRule.onNodeWithText("Save").performClick()

        composeTestRule.onNodeWithText("Run").assertExists()
        composeTestRule.onNodeWithText("25 minutes").assertExists()
    }

    @Test
    fun addEmptyActivity_showsToastError() {
        composeTestRule.onNodeWithContentDescription("Add Activity").performClick()
        composeTestRule.onNodeWithText("Save").performClick()
    }
}
