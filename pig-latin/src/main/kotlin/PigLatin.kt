
class PigLatin {
    companion object {
        val vowels = setOf("a", "e", "i", "o", "u")
        val startWithRule1 = vowels.union(setOf("xr", "yt" ))

        fun startWith(pre: Collection<String>, isIn: Boolean, word: String): Pair<String, String>? {
            if (isIn) {
                val startPair: Pair<Int, String>? = word.findAnyOf(pre, ignoreCase = true)
                if (startPair?.first == 0) {
                    return Pair<String, String> (startPair.second, word.drop(startPair.second.length))
                } 
            } else {
                val startCluster: String = word.takeWhile{!(it.toString() in pre)}
                if (startCluster != "") {
                    return Pair<String, String>(startCluster, word.drop(startCluster.length))
                }
               
            }
            return null
        }
            
        fun translateWord(input: String): String {
            val startRule1: Pair<String, String>? = startWith(startWithRule1, true, input)
            if (startRule1 != null) {
                return input + "ay"
            } else {
                if ((input.length == 2) && (input[1] == 'y')) {
                    return "${input[1]}${input[0]}ay"
                }
                if (input[0] == 'y') {
                    return input.drop(1) + "yay"
                }
                val startConsonants: Pair<String, String> = startWith(vowels.union(setOf("y")), false, input)!!

                if (startConsonants.second[0] == 'y') {
                    return startConsonants.second + startConsonants.first + "ay"
                }

                if ((startConsonants.first[startConsonants.first.lastIndex] == 'q') && (startConsonants.second[0] == 'u')) {
                    return startConsonants.second.drop(1) + startConsonants.first + "uay"
                } else {
                    return startConsonants.second + startConsonants.first + "ay"
                }
            }
        }

        fun translate(input: String): String {
            return input.split(" ").map{w -> translateWord(w.toString())}.joinToString(" ")
        }
    }

}

