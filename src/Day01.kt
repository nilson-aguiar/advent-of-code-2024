import kotlin.math.abs

fun main() {
    Day01.runDay()
}

object Day01 : Day {
    private val left = mutableListOf<Int>()
    private val right = mutableListOf<Int>()

    private fun readInput(input: List<String>) {
        input.forEach { line ->
            val (l, r) = line.split("\\s+".toRegex()).map { it.toInt() }

            left.add(l)
            right.add(r)
        }
    }

    override fun part1(input: List<String>): Int {
        readInput(input)

        val sortedLeft = left.sorted()
        val sortedRight = right.sorted()

        return sortedLeft.zip(sortedRight).sumOf {
            abs(it.first - it.second)
        }
    }

    override fun part2(input: List<String>): Int =
        left.sumOf { leftNum ->
            leftNum * right.count { it == leftNum }
        }


    override val expectedTestResultPart1: Int = 11
    override val expectedTestResultPart2: Int = 31

}

