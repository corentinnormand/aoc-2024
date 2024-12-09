package bzh.normand.aoc

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day6Test {
  @Test
  fun solve() {
    Day6().solution("""
      ....#.....
      .........#
      ..........
      ..#.......
      .......#..
      ..........
      .#..^.....
      ........#.
      #.........
      ......#...

    """.trimIndent())
    Day6().solution(Utils.getResourceAsText("/day6-2.txt"))
  }
}