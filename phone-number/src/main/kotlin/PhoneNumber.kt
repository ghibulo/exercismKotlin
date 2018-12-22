
class PhoneNumber  {
    var number: String? 

    constructor(phn: String) {
        number = getNumber(phn)
    }

    fun getNumber(input: String): String? {
        var _number: String = input.filter{it -> it.isDigit()}.reversed()
        if ((_number.length < 10)||(_number.length > 11)) return null
        if (_number[6] in listOf('0', '1')) return null
        if (_number[9] in listOf('0', '1')) return null
        if ((_number.lastIndex>=10)&&(_number[10])!='1') return null
        return _number.take(10).reversed()
    }
}
/*
 * inspiration
 *
 class PhoneNumber(raw: String?) {
  val number: String? = raw
    ?.replace(nondigits, "")
    ?.replaceFirst(countrycode, "")
    ?.let { if (it.matches(phonenumber)) it else null }
}

private val nondigits = """[^\d]""".toRegex()
private val countrycode = """^1""".toRegex()
private val phonenumber = """(?:[2-9]\d\d){2}\d{4}""".toRegex()
*/
