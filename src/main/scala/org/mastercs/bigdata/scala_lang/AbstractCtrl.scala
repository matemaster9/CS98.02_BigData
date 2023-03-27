package org.mastercs.bigdata.scala_lang

import java.io.File

object AbstractCtrl extends App {

    def twice(opr: Double => Double, arg: Double): Double = opr(opr(arg))

    println(twice(arg => arg + 100, 10.0))
    println(twice(_ + 100, 10.0))

    // 传名参数 解决类似： () => AnyRef
    def byNameAssert(predicate: => Boolean): Unit = if (!predicate) throw new AssertionError

    byNameAssert(5 > 3)

    object FileMatcher {
        private def findHere: Array[File] = new File(".").listFiles()

        def filesEnding(query: String): Array[Boolean] = findHere.map(file => file.getName.endsWith(query))

        def filesContaining(query: String): Array[Boolean] = findHere.map(_.getName.contains(query))

        def filesRegex(query: String): Array[Boolean] = findHere.map(_.getName.matches(query))
    }

    object FileMatcherRefactor {
        private def findHere: Array[File] = new File(".").listFiles()

        def filesMatching(matcher: String => Boolean): Array[Boolean] = findHere.map(file => matcher(file.getName))

        def filesEnd(query: String): Array[Boolean] = filesMatching(_.endsWith(query))

        def filesContain(query: String): Array[Boolean] = filesMatching(_.contains(query))

        def filesRegex(query: String): Array[Boolean] = filesMatching(_.matches(query))
    }


}
