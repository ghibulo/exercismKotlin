object Luhn {
    fun isValid(number: String): Boolean {
        val cleanNumber: CharArray = number.replace("\\s".toRegex(),"").toCharArray()
        if (cleanNumber.size < 2) return false
        if (cleanNumber.any{!it.isDigit()}) return false
        cleanNumber.reverse()
        val numberList: List<Int> = cleanNumber.toList().mapIndexed{ind, el -> if ((ind+1) % 2 == 0) el.toInt()*2-96 else el.toInt()-48}
        val checkSum = numberList.fold(0){sum, el -> if (el>9) sum + el -9 else sum + el}

        return (checkSum % 10 == 0)
    }

}

