object Raindrops {

    fun convert(input: Int): String {
        val result: String = input.let {
                                            (if (it % 3 == 0) "Pling" else "") + 
                                            (if (it % 5 == 0) "Plang" else "") + 
                                            (if (it % 7 == 0) "Plong" else "")
                                           }
        if ( result == "") return input.toString() else return result
    }

}

