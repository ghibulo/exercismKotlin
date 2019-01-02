class Dna (val dnaString: String) {

    init {
        if (dnaString.any{!listOf('A', 'C', 'G', 'T').contains(it)}) {
            throw IllegalArgumentException("input error")
        }
    }

    public val nucleotideCounts: Map<Char, Int>
                get() = ncCounts()

    fun ncCounts(): Map<Char, Int> {
        return dnaString.fold(hashMapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0))
                              {s,e -> val x = HashMap(s); x[e] = x[e]?.plus(1); x}
    }
}

