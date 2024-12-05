package bzh.normand.aoc

class Utils {
  companion object {
    fun getResourceAsText(path: String): String = object {}.javaClass.getResource(path)!!.readText()
  }
}
