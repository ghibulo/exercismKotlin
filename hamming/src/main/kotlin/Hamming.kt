class Hamming {
   companion object {
       fun compute(first: String, second: String): Int {
           if (first.length != second.length) {
               throw IllegalArgumentException("left and right strands must be of equal length.")
           }
           return first.zip(second).fold(0){sum, dbl -> sum + (if (dbl.first == dbl.second) 0 else 1)}
       }
   }
}
