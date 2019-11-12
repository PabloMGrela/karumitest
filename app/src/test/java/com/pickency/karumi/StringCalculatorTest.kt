package com.pickency.karumi

import org.junit.Assert.assertEquals
import org.junit.Test

class StringCalculatorTest {

    //Testing table
    private val scenarios = listOf(
        Pair("", 0),
        Pair("11", 11),
        Pair("1,2", 3),
        Pair("11,22", 33)
    )

    @Test
    fun evaluatesAllThePossibleScenarios() {
        scenarios.forEach {
            val result = StringCalculator().add(it.first)
            assertEquals(it.second, result)
        }
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