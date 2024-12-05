package bzh.normand.aoc

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day5Test {

  @Test
  fun one() {
    Day5().one(Utils.getResourceAsText("/day5.txt"))
  }

  @Test fun two() {
    Day5().two(Utils.getResourceAsText("/day5.txt"))
  }
}
