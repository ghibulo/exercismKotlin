class DiamondPrinter {

    /*
     * input:  [-2, 67, -3, 67, -2] ... 2 spaces, asciiCode('C'), 3 spaces, asciiCode('C'), 2 spaces
     * output: [-1, 68, -5, 68, -1] ... 1 space , asciiCode('D'), 5 spaces, asciiCode('D'), 1 space
     */
    fun nextRow(thisRow: List<Int>, addition: Int): MutableList<Int> {
        var result: MutableList<Int> = thisRow.toMutableList()
        result[0] += addition
        result[4] += addition
        result[1] += addition
        result[3] += addition
        result[2] -= 2*addition 

        //correction inside -> 0, 1, 3, 5 ...
        if (result[2]==1) {
            result[2] = 0  
        } else {
            if (result[2] == -2) result[2] = -1
        }
        if (result[2]==-2) result[2] = -1
        /////////////////////////////////////
        
        return result
    }

    /*
     * input:  [-2, 67, -3, 67, -2] ... 2 spaces, asciiCode('C'), 3 spaces, asciiCode('C'), 2 spaces
     * output: "  C   C  "
     */
    fun intoString(thisRow: List<Int>): String {
        val list = thisRow.map{el -> if (el<=0) "".padStart(-el).toString() else el.toChar().toString()}.filter{it -> (it != "")}
        return list.joinToString("").replace("AA","A")
    }

    fun printToList(letter: Char): List<String> {
        val diff: Int =  'A'.toInt() - letter.toInt() 
        var add: Int = 1
        var ml = mutableListOf(diff, 'A'.toInt(), 0, 'A'.toInt(), diff)
        var result: MutableList<String> = mutableListOf()
        while (true) {
            result.add(intoString(ml))
            //again 'A' or only one row -> break
            if (((add < 0) && (ml[1] == 'A'.toInt())) || (diff == 0)) break
            ml = nextRow(ml,add)
            if (ml[1] == letter.toInt()) add *= -1
        }
        return result
    }

}


