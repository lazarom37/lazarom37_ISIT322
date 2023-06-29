package com.isit322sp23.unittesting

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import java.lang.IllegalArgumentException
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import kotlin.math.exp

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GameUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    //To avoid redundancy
    private lateinit var question: Question
    @Before
    fun setup() {
        question = Question("CORRECT", "INCORRECT")
    }

    //System increments current score
    @Test
    fun whenIncrementingScore_SHALL_incrementCurrentScore() {
        val question = mock<Question>()
        val game = Game(listOf(question))
        game.incrementScore()
        assertEquals("Current score should have been 1", 1, game.currentScore)
    }
    //System increments highest score when current score > highest score
    @Test
    fun whenIncrementingCurrentScoreGreaterThanHighScore_SHALL_AlsoIncrementHighScore() {
        val question = mock<Question>()
        val game = Game(listOf(question))
        game.incrementScore()
        assertEquals(1, game.highestScore)
    }
    //Check to see that incrementing current score does not change the highest score
    @Test
    fun whenIncrementingCurrentScore_SHALL_NOT_IncrementHighestScore() {
        val question = mock<Question>()
        val game = Game(listOf(question))
        game.incrementScore()
        assertEquals(1, game.highestScore)
    }
    //System presents a question with two possible answers
    //Question has two possible answered states: Correct and Incorrect that models the player's answer
    //NULL Option is not legal
    @Test
    fun whenCreatingQuestion_SHALL_NOT_HaveNullAnsweredOption() {
        assertNull(question.answeredOption)
    }
    //System will save player answer state in answeredOption property
    @Test
    fun whenAnswering_SHALL_haveAnsweredOption() {
        question.answer("INCORRECT")
        assertEquals("INCORRECT", question.answeredOption)
    }
    //System answer() will use a Boolean to determine correct / incorrect answer
    @Test
    fun whenAnsweringWithCorrectOption_SHALL_returnTrue() {
        val result = question.answer("CORRECT")
        assertTrue(result)
    }
    //System returns false for incorrect answer
    @Test
    fun whenAnsweringWithIncorrectOption_SHALL_returnFalse() {
        val result = question.answer("INCORRECT")
        assertFalse(result)
    }
    //System answer() method allows only valid options
    @Test(expected = IllegalArgumentException::class)
    fun whenAnsweringWithInvalidOption_SHALL_ThrowException() {
        question.answer("INVALID")
    }

    //Mockito stuff

    //Set up the test. The answer() method of Game will call and answer on the Question object
    @Test
    fun whenAnswering_SHALL_DelegateTo_Question() {
        //Create a mock to test against
        val question = mock<Question>()
        val game = Game(listOf(question))
        game.answer(question, "OPTION")
        verify(question).answer(eq("OPTION"))
    }
}