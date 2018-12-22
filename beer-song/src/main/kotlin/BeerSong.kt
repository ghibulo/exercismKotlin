object BeerSong {

    var verseTable = mutableMapOf<IntRange, String>()

    init {
        verseTable[3..99] = "{a} bottles of beer on the wall, {a} bottles of beer.\nTake one down and pass it around, {b} bottles of beer on the wall.\n"
        verseTable[2..2] = "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
        verseTable[1..1] = "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
        verseTable[0..0] = "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
    }

    fun adjustedString(verse: String, index: Int): String {
        return verse.replace("{a}","$index").replace("{b}","${index-1}")
    }

    fun getVerse(ind: Int): String {
        var verse: String = ""
        for( (k,v) in verseTable ) {
            verse = v
            if (ind in k) {
                break
            }
        }
        return adjustedString(verse, ind)
    }


    fun verses(from: Int, to: Int): String {
        return  IntArray(from-to+1){from - it} //range from..to
                .map{i -> getVerse(i)} //turn into verses
                .joinToString("\n")
    }

}
/*
 * inspirace (GString simulated by string template with function, not only a variable
 
object BeerSong {
    fun verse(n: Int): String {
        require(n >= 0) { "Beer song verse can't be negative" }
        require(n < 100) { "Beer song only goes up to verse 99" }
        return when (n) {
            0 -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
            1 -> "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
            else -> "${bottles(n)} of beer on the wall, ${bottles(n)} of beer.\nTake one down and pass it around, ${bottles(n-1)} of beer on the wall.\n"
        }
    }

    fun verses(start: Int, end: Int) = (start downTo end).map { verse(it) }.joinToString("\n")

    val lyrics = verses(99, 0)

    private fun bottles(n: Int) = when (n) {
        1 -> "1 bottle"
        else -> "$n bottles"
    }
}
*/
