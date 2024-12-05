package bzh.normand.aoc

import org.junit.jupiter.api.Test

class Day3Test {

  @Test
  fun one() {
    Day3().one(Utils.getResourceAsText("/day3.txt").lines().dropLast(1))
  }

  @Test
  fun two() {
    Day3().part2(Utils.getResourceAsText("/day3.txt").lines().dropLast(1))
  }
}
