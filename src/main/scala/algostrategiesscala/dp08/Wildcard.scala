package algostrategiesscala.dp08

import java.util.Scanner

object Wildcard {

  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    val cases = sc.nextInt()

    for (_ <- 0 until cases) {
      val query: String = sc.next()
      val fileCount: Int = sc.nextInt()
      val fileNames = for (_ <- 0 until fileCount) yield sc.next()
      val result: String = WildcardProblem.orderIfMatch(fileNames.toArray, query)
      println(result)
    }
  }

  object WildcardProblem {
    def orderIfMatch(files: Array[String], query: String): String = {
      files
        .map { f =>
          (f, WildcardProblem(f, query).solve)
        }
        .filter(_._2)
        .map(_._1)
        .sorted
        .mkString("\n")
    }
  }

  case class WildcardProblem(file: String, query: String) {
    def solve: Boolean = {
      val cache = Array.fill(query.length)(Array.fill(file.length)(0))
      matchQuery(cache, 0, 0)
    }

    private def containsWildcard(from: Int): Boolean = query.drop(from).exists(c => c == '*' || c == '?')

    private def mkString(fi: Int, qi: Int): String = s"fi:$fi (${file.substring(fi)}), qi:$qi (${query.substring(qi)})"

    private def matchQuery(cache: Array[Array[Int]], fi: Int, qi: Int): Boolean =
      // End of the file name.
      if (fi == file.length) {
        // Both file and query strings are iterated through the end.
        if (qi == query.length) true
        // `?` expects there's one or more characters.
        else if (query(qi) == '?') false
        // `*` expect there's zero or more characters.
        // If `*` is at the end of query, safe to return true.
        else if (query(qi) == '*' && qi == (query.length - 1)) true
        else false
      }
      // There remains `file` characters but `query` is empty.
      else if (qi == query.length) false
      // Cache hits.
      else if (cache(qi)(fi) != 0) cache(qi)(fi) == 1
      // Update cache.
      else {
        val q = query(qi)
        val f = file(fi)

        val nextMatch: Boolean =
          // Because `?` should have to match a character, drop the first character and continue match.
          if (q == '?') matchQuery(cache, fi+1, qi+1)
          else if (q == '*') matchQuery(cache, fi+1, qi) || matchQuery(cache, fi, qi+1) || matchQuery(cache, fi+1, qi+1)
          else if (q == f) matchQuery(cache, fi+1, qi+1)
          else false

        /*
         * I originally did the following if `q` is not one of `?` or `*`:
            else if (q == f) {
              if (containsWildcard(qi)) matchQuery(cache, fi+1, qi+1) || matchQuery(cache, fi+1, qi)
              else matchQuery(cache, fi+1, qi+1)
            }
            else {
              if (containsWildcard(qi)) matchQuery(cache, fi+1, qi)
              else false
            }
         *
         * What I meant to do is to delay matching `fi` and `qi` if query has remaining wildcards.
         * But it turns out this approach is to force put `*` in front of query even though it isn't there.
         */

        cache(qi)(fi) = if (nextMatch) 1 else -1
        nextMatch
      }
  }
}
