object Isogram {
    fun isIsogram(input: String): Boolean {
        val setLetter: MutableSet<Char> = mutableSetOf<Char>()
        for (l in input) {
            if (l in setOf<Char>(' ', '-')) continue
            if (l.toLowerCase() in setLetter) {
                return false
            } else {
                setLetter.add(l.toLowerCase())
            }
        }
        return true
    }
}


/* motivation...
 * object Isogram {
    fun isIsogram(phrase: String) = phrase.toLowerCase()
            .filter(Char::isLetter)
            .let { it.toSet().size == it.length }
}

