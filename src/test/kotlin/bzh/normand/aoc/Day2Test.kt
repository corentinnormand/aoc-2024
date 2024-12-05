package bzh.normand.aoc

import bzh.normand.aoc.Utils.Companion.getResourceAsText
import org.junit.jupiter.api.Test

class Day2Test {
  @Test
  fun day1() {
    Day2().one(getResourceAsText("/day2.txt").lines().dropLast(1))
    Day2().two(getResourceAsText("/day2.txt").lines().dropLast(1))
  }
}
