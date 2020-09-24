package chapter04

object section4_2 {
  def main(args: Array[String]): Unit = {
   // ------------------------------迭代映射-----------------------------------
    val ab = Map("A"->1,"B"->2)
    for ((k,v)<-ab)
      print(k,v)
    // 只访问键
    print(ab.keySet)
    // 只访问值b
    for(v <- ab.values) println(v)
    // 翻转映射
    for((k,v)<-ab) yield (v,k)
    // ------------------------------已排序映射-----------------------------------
    //如果你需要顺序访问所有的key 你可以定义树形映射
    val scores = scala.collection.immutable.SortedMap("Alice"->10,"Fred"->7,"Bob"->3)
    print(scores.values)
    //如果你需啊按插入顺序访问所有的key
    val link_score = scala.collection.mutable.LinkedHashMap("Alice"->10,"Fred"->3)
    //--------------------------------元组-----------------------------------
    // 元组是不同类型的值得集合
    val t = (1,3.41,"A")
    // 你可以用方法 _1,_2,_3访问其组元,元组的第一个元素从1 开始
    val secone = t._2
    val third = t _3
    // 通常，使用模式匹配来获取元组的组元、
    val (fa,ja,c) = t //a 设为1 b 设为 3.41 c设为"A"
    // 如果并不是所有部件都需要，那么可以可以使用_
    val (fb,jb,_) = t
    // --------------------------------拉链操作-----------------------------------
    // 使用元组的原因之一是把多个值绑在一起，以便它们能够被一起处理，者通常可以用zip方法来完成
    val symbols = Array("<","-",">")
    val counts = Array(1,2,3)
    val pairs = symbols.zip(counts)
    for((s,n)<-pairs) Console.print(s*n)
    // 用toMap 方法可以将对偶的集合转换成映射
    print(pairs.toMap)
  }
}
