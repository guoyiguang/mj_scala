package chapter03

import scala.collection.mutable.ArrayBuffer

object section3_2 {
  def main(args: Array[String]): Unit = {
    // ------------------------------常用算法-----------------------------------
    Array(1,7,2,9).sum
    // 要使用sum方法，元素必须是数值类型
    // min max 返回数组或数组缓冲中 最小/最大的元素
    Array(2,4,1,5).max
    // sorted 方法将数组或数组缓冲排序并返回经过排序的数组或数组缓冲，这个过程并不会修改原始版本
    val b = ArrayBuffer(1,4,2,9)
    val bSorted = b.sorted.reverse
    print(bSorted)
    // 如果你想要显示数组或数组缓冲的内容，可以用mkString方法，它允许你指定元素之间的分隔符
    val a = ArrayBuffer("A","B","C")
    println(a.mkString(" and "))
    print(a.mkString("<",",",">"))
    // ------------------------------多维数组-----------------------------------
    // 多维数组是通过数组的数组来实现的
    val matrix =Array.ofDim[Double](3,4) // 3行 4列
    matrix(2)(3)=42





  }
}
