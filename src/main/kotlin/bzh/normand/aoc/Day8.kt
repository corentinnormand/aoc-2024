package bzh.normand.aoc

class Day8 : Day() {
  //............
  //........0...
  //.....0......
  //.......0....
  //....0.......
  //......A.....
  //............
  //............
  //........A...
  //.........A..
  //............
  //............
  override fun solvePart1(input: String) {
    val table = input.split("\n").dropLast(1).map { it.toCharArray().toList() }
    val map = mutableMapOf<Char, MutableSet<Pair<Int, Int>>>()
    for (i in table.indices) {
      for (j in table[i].indices) {
        if (table[i][j] != '.') {
          if (map[table[i][j]] == null) {
            map[table[i][j]] = mutableSetOf(Pair(i, j))
          } else {
            map[table[i][j]]!!.add(Pair(i, j))
          }
        }
      }
    }

    val map1 = map.values.map {
      it.combinations(2)
        .map { c -> setOf(c[0] + c[0] - c[1], c[1] + c[1] - c[0]) }
        .flatten()
        .filter { coords -> table.inBound(coords) }
        .toSet()
    }.flatten().toSet()

    val table2 = table.map { it.toMutableList() }.toMutableList()

    map1.forEach { map1 -> table2[map1.first][map1.second] = '#' }

    println(table2.joinToString(separator = "\n") { it.joinToString(separator = "") })
    println(map1.size)

  }

  override fun solvePart2(input: String) {
    val table = input.split("\n").dropLast(1).map { it.toCharArray().toList() }
    val map = mutableMapOf<Char, MutableSet<Pair<Int, Int>>>()
    for (i in table.indices) {
      for (j in table[i].indices) {
        if (table[i][j] != '.') {
          if (map[table[i][j]] == null) {
            map[table[i][j]] = mutableSetOf(Pair(i, j))
          } else {
            map[table[i][j]]!!.add(Pair(i, j))
          }
        }
      }
    }

    val map1 = map.values.map {
      it.combinations(2)
        .map { c -> generate(c[0], c[1], table) }
        .flatten()
        .filter { coords -> table.inBound(coords) && !map.values.flatten().contains(coords) }
        .toSet()
    }.flatten().toSet()
    val table2 = table.map { it.toMutableList() }.toMutableList()

    map1.forEach { map1 -> table2[map1.first][map1.second] = '#' }

    println(table2.joinToString(separator = "\n") { it.joinToString(separator = "") })

    println(map1.size + map.values.flatten().size)

  }

  fun generate(first: Pair<Int, Int>, second: Pair<Int, Int>, table: List<List<Any>>): Set<Pair<Int, Int>> {
    first - second
    val set = mutableSetOf<Pair<Int, Int>>()
    var value1 = first
    var value2 = second
    while (table.inBound(value1) || table.inBound(value2)) {
      value1 += first - second
      value2 += second - first
      set.add(value1)
      set.add(value2)
    }
    return set
  }

  fun <T> Iterable<T>.combinations(length: Int): Sequence<List<T>> =
    sequence {
      val pool = this@combinations as? List<T> ?: toList()
      val n = pool.size
      if (length > n) return@sequence
      val indices = IntArray(length) { it }
      while (true) {
        yield(indices.map { pool[it] })
        var i = length
        do {
          i--
          if (i == -1) return@sequence
        } while (indices[i] == i + n - length)
        indices[i]++
        for (j in i + 1 until length) indices[j] = indices[j - 1] + 1
      }
    }

  fun <T> Iterable<T>.permutations(length: Int? = null): Sequence<List<T>> =
    sequence {
      val pool = this@permutations as? List<T> ?: toList()
      val n = pool.size
      val r = length ?: n
      if (r > n) return@sequence
      val indices = IntArray(n) { it }
      val cycles = IntArray(r) { n - it }
      yield(List(r) { pool[indices[it]] })
      if (n == 0) return@sequence
      cyc@ while (true) {
        for (i in r - 1 downTo 0) {
          cycles[i]--
          if (cycles[i] == 0) {
            val temp = indices[i]
            for (j in i until n - 1) indices[j] = indices[j + 1]
            indices[n - 1] = temp
            cycles[i] = n - i
          } else {
            val j = n - cycles[i]
            indices[i] = indices[j].also { indices[j] = indices[i] }
            yield(List(r) { pool[indices[it]] })
            continue@cyc
          }
        }
        return@sequence
      }
    }
}