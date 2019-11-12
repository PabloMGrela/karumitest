package com.pickency.karumi

class StringCalculator {

    //The method can take 0, 1 or 2 numbers, and will return their sum (or empty for 0). for example "" or "1" or "1,2"
    //Allow the Add method to allow an undefined numbers
    //Allow \n as delimiter
    //Check negatives and throw an exception
    fun add(numbers: String) =
        when {
            numbers.isEmpty() -> 0
            numbers.contains("-") -> throw AwesomeException()
            else -> numbers.split(",", "\n").map { it.toInt() }.sum()
        }
}