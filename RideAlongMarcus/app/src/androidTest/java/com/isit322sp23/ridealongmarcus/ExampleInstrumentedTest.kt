package com.isit322sp23.ridealongmarcus

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val rule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.isit322sp23.ridealongmarcus", appContext.packageName)
    }

    @Test
    fun checkTitle() {
        onView(withId(R.id.title)).check(matches(withText("A Form to Test")))
    }

    @Test
    fun enter_FieldOne() {
        onView(withId(R.id.fieldOne)).perform(typeText("Something"))
    }

    @Test
    fun enter_FieldTwo() {
        onView(withId(R.id.fieldTwo)).perform(typeText("Something Else"))
    }

    @Test
    fun data_entry_confirmation() {
        onView(withId(R.id.fieldOne)).perform(typeText("Something"))
        onView(withId(R.id.fieldTwo)).perform(typeText("Something Else"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.message)).check(matches(withText("Confirmation")))
    }
}