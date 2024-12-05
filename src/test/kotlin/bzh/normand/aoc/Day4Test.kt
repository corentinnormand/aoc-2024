package bzh.normand.aoc

import org.junit.jupiter.api.Test

class Day4Test {
  @Test
  fun one() {
    Day4().one(Utils.getResourceAsText("/day4.txt"))
  }

  @Test
  fun two() {
    Day4().two(Utils.getResourceAsText("/day4.txt"))
  }
}
