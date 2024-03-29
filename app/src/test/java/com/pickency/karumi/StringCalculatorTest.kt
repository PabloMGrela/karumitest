package com.pickency.karumi

import org.junit.Assert.assertEquals
import org.junit.Test

class StringCalculatorTest {

    //Testing table
    private val scenarios = listOf(
        Pair("", 0),
        Pair("11", 11),
        Pair("1\n2", 3),
        Pair("11\n22", 33),
        Pair("11\n11\n11\n11\n11\n11", 66),
        Pair("", 0),
        Pair("11", 11),
        Pair("1,2", 3),
        Pair("11,22", 33),
        Pair("11,11,11,11,11,11", 66)
    )

    @Test
    fun evaluatesAllThePossibleScenarios() {
        scenarios.forEach {
            val result = StringCalculator().add(it.first)
            assertEquals(it.second, result)
        }
    }

    @Test(expected = AwesomeException::class)
    fun ifNegativeNumberIsEnteredAnExceptionIsThrown() {
        StringCalculator().add("-1")
    }

    @Test(expected = AwesomeException::class)
    fun ifSeparatorIsNotAcceptedAnExceptionIsThrown() {
        StringCalculator().add("23.12")
    }

//    @Test
//    fun returnsZeroIfStringIsEmpty() = evaluateStringCalculator("", 0)
//
//    @Test
//    fun returnsTheNumberPassedAsParameterIfThereIsOnlyOne() = evaluateStringCalculator("1", 1)
//
//    @Test
//    fun returnsTheSumOfTheNumbersSeparatedByComa() = evaluateStringCalculator("11,22", 33)
//
//    @Test
//    fun returnsTheSumOfTheNumbersSeparatedByComaWithSmallNumbers() = evaluateStringCalculator("1,2", 3)

//    private fun evaluateStringCalculator(input: String, expectedResult: Int) {
//        val result = StringCalculator().add(input)
//        assertEquals(expectedResult, result)
//    }

}