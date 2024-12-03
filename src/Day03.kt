fun main() {
    Day03.runDay()
}

object Day03 : Day {

    override fun part1(input: List<String>): Int {
        val regex = Regex("mul\\(([0-9]+),([0-9]+)\\)")

        return regex.findAll(input.joinToString(","))
            .sumOf {
                val (param1, param2) = it.groupValues.drop(1)

                param1.toInt() * param2.toInt()
            }
    }


    override fun part2(input: List<String>): Int  {
        val regex = Regex("(mul|do(?:n't)?)\\(([0-9]*),?([0-9]*)\\)")

        var shouldSum = true


        return regex.findAll(input.joinToString(","))
            .sumOf {
                val (operation, param1, param2) = it.groupValues.drop(1)

                when(operation) {
                    "do" -> {
                        shouldSum = true
                        0
                    }
                    "don't" -> {
                        shouldSum = false
                        0
                    }
                    "mul" -> {
                        if(shouldSum) {
                            param1.toInt() * param2.toInt()
                        } else 0
                    }
                    else -> 0
                }
            }
    }

    override val expectedTestResultPart1: Int = 161
    override val expectedTestResultPart2: Int = 48

}

