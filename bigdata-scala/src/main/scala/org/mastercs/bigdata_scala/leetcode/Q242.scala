package org.mastercs.bigdata_scala.leetcode

/**
  *
  * @author HUAWEI
  * @date 2023/4/5 2:20
  */
object Q242 {

  def isAnagram(s: String, t: String): Boolean = {
    s.sorted == t.sorted
  }
}
