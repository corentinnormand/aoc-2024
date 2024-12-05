package bzh.normand.aoc

import java.time.LocalTime

class Day5: Day() {

  override fun solvePart1(input: String) {
    val (first, second) = input.split("\n\n")
    val order =
      first
        .split("\n")
        .map { it.split("|").let { p -> p[0].toInt() to p[1].toInt() } }
        .groupBy { it.first }
        .mapValues { it.value.map { it.second }.toSet() }
    val values = second.split("\n").dropLast(1).map { it.split(",").map { s -> s.toInt() } }
    println(
      values
        .filter {
          it.windowed(2, 1) { w -> w.let { w[0] to w[1] } }
            .fold(true) { acc, v -> acc && order[v.first]?.contains(v.second) == true }
        }
        .sumOf { it[it.size / 2] })

  }

  override fun solvePart2(input: String) {
    val (first, second) = input.split("\n\n")
    val order =
      first
        .split("\n")
        .map { it.split("|").let { p -> p[0].toInt() to p[1].toInt() } }
        .groupBy { it.first }
        .mapValues { it.value.map { it.second }.toSet() }
    val values = second.split("\n").dropLast(1).map { it.split(",").map { s -> s.toInt() } }
    println(
      values
        .filter {
          !it.windowed(2, 1) { w -> w.let { w[0] to w[1] } }
            .fold(true) { acc, v -> acc && order[v.first]?.contains(v.second) == true }
        }
        .map {
          it.sortedWith { o1, o2 ->
            order[o1]?.contains(o2).let { b -> if (b == true) -1 else 1 }
          }
        }
        .sumOf { it[it.size / 2] })
  }
}
