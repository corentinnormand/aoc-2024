package bzh.normand.aoc

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day5Test {

  @Test
  fun one() {
    Day5().solvePart1(Utils.getResourceAsText("/day5.txt"))
  }

  @Test
  fun two() {
    Day5().solvePart2(Utils.getResourceAsText("/day5.txt"))
  }

  @Test
  fun all() {
    Day5().solution(Utils.getResourceAsText("/day5.txt"))
  }

}
