class IsbnVerifier {
    fun isValid(isbn: String): Boolean {
        val cleaned: String = isbn.filter{listOf('0','1','2','3','4','5','6','7','8','9','X').contains(it)}
        if (cleaned.length != 10) return false
        if (cleaned.take(9).any{it == 'X'}) return false
        val list = cleaned.toList().mapIndexed{ind, el -> if (el == 'X') 10*(10-ind) else (el.toInt()-48)*(10-ind)}
        return ((list.sum() % 11) == 0)
    }

}
