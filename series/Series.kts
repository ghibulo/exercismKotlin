object Series {

    fun slices(count: Int, nums: String): List<List<Int>> {
        val arr = Array<String>(nums.length, { _ -> nums })
        return arr.mapIndexed{ind,el -> el.drop(ind)}
                    .filter{a -> a.length>=count}
                    .map{el -> el.take(count).toList().map{ch -> ch.toInt()-48}}
    }
}

