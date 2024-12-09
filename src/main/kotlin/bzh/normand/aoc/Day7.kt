package bzh.normand.aoc

class Day7 : Day() {
  override fun solvePart1(input: String) {

    val map = input.split("\n").dropLast(1)
      .asSequence()
      .map { it.split(":").let { s -> s[0] to s[1] } }
      .map { it.first.toLong() to it.second.trim().split(" ").map { v -> v.toLong() } }
      .toList()
      .filter { calc1(it.second).contains(it.first) }
      .sumOf { it.first }
    println(map)
  }

  override fun solvePart2(input: String) {
    val map = input.split("\n").dropLast(1)
      .asSequence()
      .map { it.split(":").let { s -> s[0] to s[1] } }
      .map { it.first.toLong() to it.second.trim().split(" ").map { v -> v.toLong() } }
      .toList()
      .filter { calc2(it.second).contains(it.first) }
      .sumOf { it.first }
    println(map)
  }

  private fun calc1(list: List<Long>): Set<Long> {
    return if (list.size == 2) {
      setOf(list[0] * list[1], list[0] + list[1])
    } else {
      calc1(list.dropLast(1)).map { setOf(it * list.last(), it + list.last()) }
        .flatten()
        .toSet()
    }
  }


  private fun calc2(list: List<Long>): Set<Long> {
    return if (list.size == 2) {
      setOf(list[0] * list[1], list[0] + list[1], "${list[0]}${list[1]}".toLong())
    } else {
      calc2(list.dropLast(1)).map { setOf(it * list.last(), it + list.last(),"${it}${list.last()}".toLong()) }
        .flatten()
        .toSet()
    }
  }

}