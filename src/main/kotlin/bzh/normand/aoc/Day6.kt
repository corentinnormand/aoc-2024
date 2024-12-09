package bzh.normand.aoc

import kotlin.system.exitProcess

class Day6 : Day() {
  private val directions = mapOf(
    "UP" to (-1 to 0),
    "RIGHT" to (0 to 1),
    "DOWN" to (1 to 0),
    "LEFT" to (0 to -1)
  )

  override fun solvePart1(input: String) {
    val map = input.split("\n")
      .dropLast(1)
      .map { it.toCharArray().toList() }
    var guardPosition: Pair<Int, Int> = 0 to 0



    for (line in map.indices) {
      for (row in map[line].indices) {
        if (map[line][row] == '^') {
          guardPosition = Pair(line, row)
        }
      }
    }

    val startPos = guardPosition.copy()
    var guard = Guard(position = startPos, direction = "UP")
    val positions = mutableSetOf<Pair<Int, Int>>()
    positions.add(startPos)
    while (inBound(guard.position.first, guard.position.second, map)) {
      guard = nextPos(guard, map)
      if (inBound(guard.position, map))
        positions.add(guard.position)
    }
    println(positions.size)
  }

  override fun solvePart2(input: String) {
    val map = input.split("\n")
      .dropLast(1)
      .map { it.toCharArray().toList() }
    var guardPosition: Pair<Int, Int> = 0 to 0



    for (line in map.indices) {
      for (row in map[line].indices) {
        if (map[line][row] == '^') {
          guardPosition = Pair(line, row)
        }
      }
    }

    val startPos = guardPosition.copy()
    var guard = Guard(position = startPos, direction = "UP")
    val positions = mutableSetOf<Pair<Int, Int>>()
    positions.add(startPos)
    while (inBound(guard.position.first, guard.position.second, map)) {
      guard = nextPos(guard, map)
      if (inBound(guard.position, map))
        positions.add(guard.position)
    }
    val count = positions.filter { it != startPos }
      .map {
        val newValues = map.toMutableList().map { l -> l.toMutableList() }
        newValues[it.first][it.second] = '#'
        it to isLooping(startPos, newValues)
      }
      .filter { it.second }
      .map { it.first }

//    println(count)
    println(count.size)

  }

  fun isLooping(startPos: Pair<Int, Int>, map: List<List<Char>>): Boolean {
    var guard1 = Guard(position = startPos, direction = "UP")
    var guard2 = Guard(position = startPos, direction = "UP")
    while (inBound(guard1.position, map) &&
      inBound(guard2.position, map)
    ) {
      guard1 = nextPos(guard1, map)
      guard2 = nextPos(nextPos(guard2, map), map)
      if (guard1 == guard2) {
        return true
      }
    }
    return false
  }

  fun isLooping2(startPos: Pair<Int, Int>, map: List<List<Char>>): Boolean {
    var guard = Guard(position = startPos, direction = "UP")
    val positions = mutableMapOf<Pair<Int, Int>, MutableSet<String>>()
    while (inBound(guard.position, map)) {
      if (positions[guard.position]?.contains(guard.direction) == true) {
        return true
      }
//      if (inBound(guard.position, map)) {
      if (positions[guard.position] == null) {
        positions[guard.position] = mutableSetOf(guard.direction)
      } else {
        positions[guard.position]!!.add(guard.direction)
      }
//      }


      guard = nextPos(guard, map)
    }
    return false
  }

  private fun nextPos(
    guard: Guard,
    map: List<List<Char>>,
  ): Guard {
    var dir = guard.direction
    var dirValue = directions[guard.direction]!!
    val next = guard.position + dirValue
    if (
      inBound(next, map) &&
      map[next.first][next.second] == '#'
    ) {
      dir = when (dir) {
        "UP" -> "RIGHT"
        "RIGHT" -> "DOWN"
        "DOWN" -> "LEFT"
        "LEFT" -> "UP"
        else -> throw Exception("merde")
      }
      dirValue = directions[dir]!!
    }

    return Guard(
      position = guard.position + dirValue,
      direction = dir,
    )
  }

  data class Guard(val position: Pair<Int, Int>, val direction: String)

  private fun inBound(line: Int, row: Int, lines: List<List<Char>>): Boolean =
    line in lines.indices && row in lines[0].indices

  private fun inBound(coords: Pair<Int, Int>, lines: List<List<Char>>): Boolean =
    coords.first in lines.indices && coords.second in lines[0].indices

  private operator fun Pair<Int, Int>.plus(o: Pair<Int, Int>): Pair<Int, Int> =
    Pair(this.first + o.first, this.second + o.second)

}
