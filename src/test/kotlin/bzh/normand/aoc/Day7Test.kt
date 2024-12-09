package bzh.normand.aoc

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day7Test {

  @Test
  fun solvePart1() {
    Day7().solution("""
      190: 10 19
      3267: 81 40 27
      83: 17 5
      156: 15 6
      7290: 6 8 6 15
      161011: 16 10 13
      192: 17 8 14
      21037: 9 7 18 13
      292: 11 6 16 20
      
    """.trimIndent())
    Day7().solution(Utils.getResourceAsText("/day7.txt"))

  }

}