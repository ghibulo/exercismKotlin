object Bob {

	fun hey(input: String): String {
        var regex = """[^a-z]+""".toRegex()
        if (regex.matches(input)) {
            if (input[input.lastIndex] == '?') {
                if ("""[A-Z\s?]+""".toRegex().matches(input)) {
                    return  "Calm down, I know what I'm doing!"
                }
            } else {
                if ("""[A-Z]+""".toRegex().containsMatchIn(input)) {
                    return "Whoa, chill out!"
                }
            }
        }
        regex = """[\s]*""".toRegex()
        if (regex.matches(input)) {
            return "Fine. Be that way!" 
        } else {
            if (input[input.trim().lastIndex] == '?') {
                return  "Sure."
            } 
        }
        return "Whatever."
    }

}
