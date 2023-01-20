package io.github.marmer.kata.theobserverpin

private var neighbors = mapOf(
    0 to listOf(0, 8),
    1 to listOf(1, 2, 4),
    2 to listOf(1, 2, 3, 5),
    3 to listOf(2, 3, 6),
    4 to listOf(1, 4, 5, 7),
    5 to listOf(2, 4, 5, 6, 8),
    6 to listOf(3, 5, 6, 9),
    7 to listOf(4, 7, 8),
    8 to listOf(0, 5, 7, 8, 9),
    9 to listOf(6, 8, 9),
)

fun getPINs(typedNumber: String): List<String> {
    return getDigitsFor(typedNumber.toCharArray().map { it.digitToInt() })
}

fun getDigitsFor(typedNumber: List<Int>): List<String> = when (typedNumber.size) {
    0 -> emptyList()
    1 -> neighbors[typedNumber[0]]!!.map { it.toString() }
    else -> {
        val nextDigitCombinations = getDigitsFor(typedNumber.drop(1))
        neighbors[typedNumber[0]]!!.flatMap { head -> nextDigitCombinations.map { tail -> head.toString() + tail } }
    }
}


