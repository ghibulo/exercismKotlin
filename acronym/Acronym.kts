object Acronym {
    fun generate(phrase: String): String = phrase.replace("[^A-Za-z0-9]{1,}".toRegex(), " ").split(" ").map{it[0].toUpperCase()}.joinToString("")
}

