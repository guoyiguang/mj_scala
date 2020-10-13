package chapter05

// --------------------------主构造器--------------------------------------
/**
 * 1.主构造器的参数直接放置在类名之后
 * 2.主构造器会执行类定义中的所有语句。
 */
// 构造参数如果不带val 或者 var，这样的参数如何处理取决去他们在类中如何被使用
class Lisi(val name: String,age:Int) {
  // println 是主构造器的一部分，每当有对象构造出来时 ，下述代码都会执行
  println("Just constructed another person")
  // 下述代码初始了不可变字段 name 和 age，那么这两个都是对象私有的
  def description = "name is "+name+"age is" + age + "years old"
}
// --------------------------嵌套类--------------------------------------

import scala.collection.mutable.ArrayBuffer
class Network {
  class Member(val name:String){
    val contacts = new ArrayBuffer[Member]()
  }
  private val members = new ArrayBuffer[Member]()
  def join(name:String) = {
    val m = new Member(name)
    members += m
    m
  }
}

object section5_3 {
  def main(args: Array[String]): Unit = {
    val chatter = new Network
    val myFace = new Network
    // 在 scala中，每个实例都有它自己的Member类，就和它们有自己的members字段一样。
    // 也就是说 chatter.Member 和 myFace.Member是不同的两个类
    val fred = chatter.join("Fred")
    val wilma = chatter.join("Wilma")
    fred.contacts += wilma //OK
    val barney = myFace.join("Barney")
    // fred.contacts += bareny

  }
}
