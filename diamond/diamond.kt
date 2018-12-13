fun nextRow(thisRow: List<Int>): List<Int> {
    var result: List<Int> = thisRow.clone()
    if (result[0]<0) {
        result[0]++
        result[result.length]++
    }
    return result
}

println (nextRow([-5, 98, -5])
