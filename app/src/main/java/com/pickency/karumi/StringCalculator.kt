package com.pickency.karumi

class StringCalculator {

    //The method can take 0, 1 or 2 numbers, and will return their sum (or empty for 0). for example "" or "1" or "1,2"
    fun add(numbers: String) =
        if (numbers.isEmpty()) 0
        else {
            numbers.split(",").map { it.toInt() }.sum()
        }
}