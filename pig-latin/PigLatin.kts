//test run -> kotlinc -script PigLatin.kts

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

println(PigLatin.translate("apple"))
println(PigLatin.translate("chair"))
println(PigLatin.translate("square"))
println(PigLatin.translate("yttria"))
println(PigLatin.translate("xray"))
println(PigLatin.translate("my"))
println(PigLatin.translate("rhythm"))
println(PigLatin.translate("banana"))
println(PigLatin.translate("cherry"))
println(PigLatin.translate("eat"))
println(PigLatin.translate("pie"))
println(PigLatin.translate("three"))
println(PigLatin.translate("school"))
println(PigLatin.translate("quiet"))
println(PigLatin.translate("the"))
println(PigLatin.translate("quick"))
println(PigLatin.translate("brown"))
println(PigLatin.translate("fox"))
println(PigLatin.translate("yellow"))


/*
 * for inspiration....
 *
 *
 *
 *
object PigLatin {
  fun translate( phrase : String ) =
    phrase
      .split(" ")
      .map {
        word ->
          when {
            word.first().isVowel() -> word + "ay"
            listOf("yt", "xr").contains(word.take(2)) -> word + "ay"
            listOf("sch", "thr", "squ").contains(word.take(3)) -> word.takeLast(word.length - 3) + word.take(3) + "ay"
            listOf("ch", "sh", "qu", "th", "rh").contains(word.take(2)) -> word.takeLast(word.length - 2) + word.take(2) + "ay"
            else -> word.takeLast(word.length - 1) + word.first() + "ay"
          }
      }.joinToString( separator = " ")
}

fun Char.isVowel() = listOf('a', 'e', 'i', 'o', 'u').contains(this)
fun Char.isConsonant() = !this.isVowel()
