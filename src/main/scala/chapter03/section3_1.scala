package chapter03

object section3_1 {
  def main(args: Array[String]): Unit = {
    // ------------------------------定长数组-----------------------------------
    // 如果你需要一个长度不变的数组，可以用Scala中的Array
    val nums = new Array[Int](20) // 10个元素的整数数组，所有元素初始化为null
    val a = new Array[String](10) // 10个元素的字符串数组
    val s = Array("hello","world") // 长度为2的字符串数组，类型是推断出来的
    print(s(0)) // 使用（） 而不是【】 来访问元素
    // ------------------------------变长数组：数组缓冲-----------------------------------
    // 对于那种长度按需要变化的数组，Scala中的等效数据结构为ArrayBuffer
    import scala.collection.mutable.ArrayBuffer
    val b = ArrayBuffer[Int]() // 定义一个空的数组缓冲
    b+=1 // 用 += 在数组缓冲末尾加1
    b+=(2,3,4) // 在末尾添加多个元素
    b.trimEnd(2) // 移除最后2个元素
    // 在数组缓冲的尾端添加或移除元素是一个高效的操作，但是在中间插入就不是
    b.insert(2,5) // 在下标位置为2 的地方插入6
    b.insert(2,6,7,8,9) // 在下标为2 的地方插入 6，7，8，9
    b.remove(2,3) // 从下标为2的位置开始移除3个元素
    a.toArray // 定长数组转变长
    b.toBuffer// 变长转定长
    // ------------------------------遍历数组：数组缓冲-----------------------------------
    for (i<-0 until b.length)
      println(b(i))  // 变量i的取值从
    // util 是RichInt类的方法，返回所有小于（但不包括）上限的数字。 0 util 10 实际是 0.util(10)
    // 如果想要每两个元素一跳，可以让i这样来进行遍历
    0 until (b.length,2)
    // 如果在循环体中不需要用到数组下标，我们也可以直接访问数组元素
    for(elem<-b)
      print(elem)

    // ------------------------------数组转换-----------------------------------
    // 从一个数组出发，以某种方式对它进行转换是很简单的，这些转换动作并不会改变原数组
    val old = Array(2,3,4,5)
    val new_array = for(elem<-old) yield 2*elem // for(...)yield 产生新组合
      //result Array(4,6,8,10)
    for(elem<-old if elem%2==0)yield 2*elem //通过守卫 来产生特定集合
    // 以下通过 filter map 产生新集合
    old.filter(_%2==0).map(2*_)

    //案例：给定一个数组缓冲，我们想要移除第一个负数之外的所有负数。

    print("*"*40)
    val ary = ArrayBuffer(2,3,-1,0,-2,5,-3,-2)
    var first = true
    val indexes = for(i<-0 until ary.length if  first||ary(i)>=0) yield {if (ary(i)<0) first=false;i}
    // 然后将元素移动到该去的位置
    print(indexes)
    for(j<-0 until indexes.length) ary(j) = ary(indexes(j))
    print(ary)
    ary.trimEnd(a.length-indexes.length)

  }

}
