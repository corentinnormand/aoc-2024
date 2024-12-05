package bzh.normand.aoc

class Day3 {

  fun one(lines: List<String>) {
    val regex = "mul\\(([0-9]{1,3}),([0-9]{1,3})\\)".toRegex()

    val map =
        lines
            .flatMap { l ->
              regex.findAll(l).toList().map {
                it.groupValues[1].toInt() * it.groupValues[2].toInt()
              }
            }
            .sum()
    println(map)
  }

  fun part2(lines: List<String>) {
    val input = lines.joinToString("")
    val sb = StringBuilder()
    var enabled = true
    for (i in input.indices) {
      if (i < input.length - 4 && input.substring(i, i + 4) == "do()") enabled = true
      else if (i < input.length - 7 && input.substring(i, i + 7) == "don't()") enabled = false
      if (enabled) sb.append(input[i])
    }
    one(listOf(sb.toString()))
  }
}
