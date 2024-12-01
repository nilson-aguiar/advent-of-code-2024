
interface Day {

    fun part1(input: List<String>): Int
    fun part2(input: List<String>): Int

    val expectedTestResultPart1: Int
    val expectedTestResultPart2: Int

    fun runDay() {
        println(this::class.simpleName!!)
        run(this::class.simpleName!!.createFiles(), ::part1, ::part2, ::expectedTestResultPart1.get(), ::expectedTestResultPart2.get())
    }

}
