package bzh.normand.aoc

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day8Test {
  @Test
  fun test() {
    Day8().solution("""
      ............
      ........0...
      .....0......
      .......0....
      ....0.......
      ......A.....
      ............
      ............
      ........A...
      .........A..
      ............
      ............
      
    """.trimIndent())
 Day8().solution("""
      T....#....
      ...T......
      .T....#...
      .........#
      ..#.......
      ..........
      ...#......
      ..........
      ....#.....
      ..........
      
    """.trimIndent())

    Day8().solution(Utils.getResourceAsText("/day8.txt"))
  }
}