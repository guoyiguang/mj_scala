package chapter04

object section4_1 {
  def main(args: Array[String]): Unit = {
    // ------------------------------构造映射-----------------------------------
    // 构造y一个不可变映射
    val scores = Map("Alice"->10,"Bob"->3,"Cidy"->8)
    // 构造一个可变映射
    val scores2 = scala.collection.mutable.Map("Alice"->10,"Bob"->3,"Cidy"->8)
    // 如果想从一个空的映射开始，你需要设定一个映射实现并给出类型
    val scores3 =new  scala.collection.mutable.HashMap[String,Int]
    // ------------------------------获取映射中的值-----------------------------------
    val bobsScore = scores("Bob") // 如果没有则会报异常
    print(bobsScore)
    // 检查映射中是否有某个指定的值，可以用contains
    val bobsScores = if(scores.contains("Bob")) scores("Bob") else 0
    // 下面是上面的简化
    val bobsScores2 = scores.getOrElse("Bob",0)
    //  映射.get（健）这样的调用返回一个Option对象，要么是Some（健对应的值）要么是None

    // ------------------------------更新映射中的值-----------------------------------
    scores2("Bob")=10 // 修改可变映射中的值
    scores2("Fred")=11 // 新增可变映射中的值
    scores2+=("A"->1,"B"->2) // += 添加多个值
    scores2-=("B") //删除值
    //可以通过构建一个新的映射来改变不可变映射
    val newSource = scores+("A"->1,"B"->2)
    val newSoucce2 = scores-("A")
  }
}
