object Hamming {
       fun compute(first: String, second: String): Int {
           require(first.length == second.length) { "left and right strands must be of equal length." }
           return first.zip(second).count{it.first != it.second}
                                   //fold(0){sum, dbl -> sum + (if (dbl.first == dbl.second) 0 else 1)}
       }
}
