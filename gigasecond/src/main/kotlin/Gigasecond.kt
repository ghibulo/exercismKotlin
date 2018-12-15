import java.time.*

class Gigasecond()  {
    constructor (_fromDate: LocalDate) : this() {
        fromDate = _fromDate.atTime(0,0)
    }
    constructor (_fromDate: LocalDateTime) : this() {
        fromDate = _fromDate
    }
    var fromDate: LocalDateTime = LocalDateTime.now()

    var date:  LocalDateTime  = fromDate
        get() = fromDate.plusSeconds(1000000000)
}

