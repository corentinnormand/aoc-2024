package bzh.normand.aoc

import kotlin.time.measureTime

abstract class Day {
  abstract fun solvePart1(input: String)

  abstract fun solvePart2(input: String)

  fun solution(input: String) {
    val timePart1 = measureTime { solvePart1(input) }
    val timePart2 = measureTime { solvePart2(input) }
    println("time part1: ${timePart1.inWholeMilliseconds}ms")
    println("time part2: ${timePart2.inWholeMilliseconds}ms")
  }
}
