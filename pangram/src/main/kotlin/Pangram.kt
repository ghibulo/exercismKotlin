object Pangram {
    fun isPangram(input: String): Boolean {
        return input.toLowerCase().filter{it.isLetter()}.let { it.toSet().size == 26}
    }

}
