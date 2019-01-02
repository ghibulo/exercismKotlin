object RomanNumeral {

    fun translate(digChar: Char, position: Int): String {
        val dig = Character.getNumericValue(digChar)
        val chars = when (position) {
            4    -> Triple("M", "", "")
            3    -> Triple("C", "D", "M")
            2    -> Triple("X", "L", "C")
            1    -> Triple("I", "V", "X")
            else -> Triple("E", "E", "E")
        }

        return when (dig) {
            in 1..3 -> chars.first.repeat(dig)
            4    -> chars.first + chars.second
            5    -> chars.second
            in 6..8 -> chars.second + chars.first.repeat(dig-5)
            9    -> chars.first + chars.third
            else -> ""
        }
    }

    fun value(input: Int): String {
        val inputString = input.toString()
        return inputString.mapIndexed{ind, dig -> translate(dig, inputString.length - ind)}.joinToString(separator="")
    }
}

