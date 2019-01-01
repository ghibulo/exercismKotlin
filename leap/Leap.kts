
class Year(val year: Int) {

    val isLeap: Boolean 
        get() = if ((year % 4 == 0)&&(year % 100 != 0)) true 
                else 
                    if (year % 400 == 0) true else false
}

