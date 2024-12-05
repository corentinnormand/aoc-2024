package bzh.normand.aoc

class Day4 {
  fun one(input: String) {
    var count = 0
    val lines = input.lines().dropLast(1)
    for (line in lines.indices) {
      for (row in lines[line].indices) {
        if (lines[line][row] == 'X') {
          for (i in -1..1) {
            for (j in -1..1) {
              if (inBound(line + i, row + j, lines) &&
                  inBound(line + i * 2, row + j * 2, lines) &&
                  inBound(line + i * 3, row + j * 3, lines) &&
                  lines[line + i][row + j] == 'M' &&
                  lines[line + i * 2][row + j * 2] == 'A' &&
                  lines[line + i * 3][row + j * 3] == 'S') {
                count++
              }
            }
          }
        }
      }
    }
    println(count)
  }

  fun two(input: String) {
    var count = 0
    val lines = input.lines().dropLast(1)
    for (line in lines.indices) {
      for (row in lines[line].indices) {
        if (lines[line][row] == 'A' &&
            inBound(line - 1, row - 1, lines) &&
            inBound(line + 1, row - 1, lines) &&
            inBound(line - 1, row + 1, lines) &&
            inBound(line + 1, row + 1, lines)) {
          val values =
              listOf(
                  lines[line + 1][row + 1],
                  lines[line + 1][row - 1],
                  lines[line - 1][row - 1],
                  lines[line - 1][row + 1])
          var old = values.first()
          var ok = false
          if (values
              .groupBy { it }
              .let { it.size == 2 && it['M']?.size == 2 && it['S']?.size == 2 }) {
            for (v in values.drop(1)) {
              if (v == old) {
                ok = true
              }
              old = v
            }
            if (ok) count++
          }
        }
      }
    }

    println(count)
  }

  private fun inBound(line: Int, row: Int, lines: List<String>): Boolean =
      line in lines.indices && row in 0..<lines[0].length
}
