package bzh.normand.aoc

import kotlin.time.measureTime

abstract class Day {
  abstract fun solvePart1(input: String)

  abstract fun solvePart2(input: String)

  fun solution(input: String) {
    println("=====")
    val timePart1 = measureTime { solvePart1(input) }
    println("time part1: ${timePart1.inWholeMilliseconds}ms")
    val timePart2 = measureTime { solvePart2(input) }
    println("time part2: ${timePart2.inWholeMilliseconds}ms")
  }


  companion object {

    fun List<List<Any>>.inBound(coords: Pair<Int, Int>): Boolean =
      coords.first in this.indices && coords.second in this[0].indices

  }


}

operator fun Pair<Int, Int>.plus(o: Pair<Int, Int>): Pair<Int, Int> =
  Pair(this.first + o.first, this.second + o.second)

operator fun Pair<Int, Int>.minus(o: Pair<Int, Int>): Pair<Int, Int> =
  Pair(this.first - o.first, this.second - o.second)