class Anagram (val word: String) {

    fun match(variants: List<String>): Set<String> {
        
        var adjustedVariants = variants.map{el -> var x = el.toLowerCase().toCharArray().sorted();listOf(el,x)}
        val smallWord = word.toLowerCase()
        val adjustedWord = smallWord.toCharArray().sorted()
        return adjustedVariants.filter{((it[1] == adjustedWord)&&(it[0].toString().toLowerCase() != smallWord))}.map{el -> el[0].toString()}.toSet()
    }
}
