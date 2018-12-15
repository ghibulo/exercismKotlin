    fun transcribeToRna(input: String): String {
        val trans = hashMapOf("G" to "C", "C" to "G", "T" to "A", "A" to "U")
        return input.map{trans[it.toString()]}.joinToString("")
    }

//println (RnaTranscription.transcribeToRna("ACGTGGTCTTAA"))
