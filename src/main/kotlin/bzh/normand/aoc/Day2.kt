package bzh.normand.aoc

import kotlin.math.abs
import kotlin.math.sign

class Day2 {

  fun one(lines: List<String>) {
    val count =
        lines
            .map { it.split(" ").map { s -> s.toInt() } }
            .map {
              (it == it.sorted() || it == it.sortedDescending()) &&
                  it.foldIndexed(true) { index, acc, i ->
                    if (index == 0) true else acc && abs(it[index - 1] - i) in 1..3
                  }
            }
            .count { it }

    println(count)

    //    for (line in lines) {
    //      var lastVal = 0
    //      var safe = true
    //      var desc = true
    //      for (value in line) {
    //        if (lastVal == 0) {
    //          lastVal = value
    //        } else {
    //          desc = lastVal - value > 0
    //          if ((lastVal - value).sign == lastVal.sign && abs(lastVal - value) in 1..3) {
    //            lastVal = value
    //          } else {
    //            safe = false
    //          }
    //        }
    //      }
    //      if (safe) {
    //        res += 1
    //      }
    //    }
  }

  fun two(lines: List<String>) {
    val count =
        lines
            .map { it.split(" ").map { s -> s.toInt() } }
            .map {
              if (isSafe(it)) true
              else
                  (0..it.size)
                      .map { indexToRemove ->
                        it.filterIndexed { index, _ -> index != indexToRemove }
                      }
                      .map { l -> isSafe(l) }
                      .reduce(Boolean::or)
            }
            .count { it }

    println(count)
  }

  fun isSafe(list: List<Int>): Boolean {
    val first = (list[0] - list[1])
    for (i in list.indices) {
      if (i > 0 &&
          (abs(list[i - 1] - list[i]) !in 1..3 || (list[i - 1] - list[i]).sign != first.sign))
          return false
    }
    return true
  }
}
