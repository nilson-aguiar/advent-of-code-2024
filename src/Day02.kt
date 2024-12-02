fun main() {
    Day02.runDay()
}

object Day02 : Day {
    data class Report(val levels: List<Int>) {
        val orderedLevels =
            if(levels.first() > levels.last()) levels.reversed()
            else levels

        fun isSafe(): Boolean {
            for (i in 0..< orderedLevels.size - 1) {
                val diff = orderedLevels[i + 1] - orderedLevels[i]
                if (diff !in 1..3) return false
            }
            return true
        }

        fun isSafeWithDampener(): Boolean {
            if (isSafe()) return true // Already safe
            for (i in orderedLevels.indices) {
                val modifiedLevels = orderedLevels.toMutableList()
                modifiedLevels.removeAt(i)
                if (Report(modifiedLevels).isSafe()) return true
            }
            return false
        }

    }


    override fun part1(input: List<String>): Int {
        input.map { report ->
            Report(report.split(" ").map { it.toInt() })
        }.filter {
            it.isSafe()
        }.also {
            return it.size
        }
    }


    override fun part2(input: List<String>): Int  {
        input.map { report ->
            Report(report.split(" ").map { it.toInt() })
        }.filter {
            it.isSafeWithDampener()
        }.also {
            return it.size
        }
    }

    override val expectedTestResultPart1: Int = 2
    override val expectedTestResultPart2: Int = 4

}

