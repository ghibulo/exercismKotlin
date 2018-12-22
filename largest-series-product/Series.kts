class Series(val serie: String) {

    init {
        if (serie.any{!(it.isDigit())}) {
            throw IllegalArgumentException("only digits!")
        }
    }

    
    val strToListOfProducts: String.(Int) -> List<Int> = 
                    { count ->    this.repeat(this.length)
                                      .chunked(this.length) //maybe there is a better way how to get the complet String inside map?
                                      .mapIndexed{ind,el -> el.getSubForProduct(ind,count) } 
                                      .filterNotNull()
                                      .map{it.toProduct()!!}
                    }

    fun String.getSubForProduct(order: Int, count: Int): String? =
                    try {
                      this.substring(order, order + count)
                    } catch (e: StringIndexOutOfBoundsException) {
                      null
                    }

    fun String.toProduct(): Int? {
        var result: Int? = null
        try {
            result = this.map{el -> el.toString().toInt()}.fold(1){p,e -> p*e}
        } catch (e: NumberFormatException) { }
        return result
    }


    fun getLargestProduct(count: Int): Int? {
        require ((count>=0)&&(count <= serie.length)) { "wrong input" }
        if (count == 0) return 1
        return serie.strToListOfProducts(count).max() 
    }

}

/*
only for inspiration... function 'windowed'
class Series(val value: String) {
    init {
        require(value.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int) = when {
        span > value.length -> throw IllegalArgumentException("span must be less than or equal to series length")
        span == 0 -> 1
        else -> value.map { it.toString().toInt() }.windowed(size = span).map { it.multiply() }.max()!!
    }
}

private fun List<Int>.multiply() = reduce { sum, i -> sum * i }
*/
