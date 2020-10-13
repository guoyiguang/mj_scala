package chapter05

// ------------------------------简单类和无参方法-----------------------------------

class Counter {
  private var value = 0 // 必须初始化字段
  def increment(){ value +=1} //方法默认是公有的
  def current = value
}
// --------------------------带getter和setter的属性---------------------------------------
// scala 对每个字段都提供getter 和 setter方法。
class Person{
  var age=0 // 私有age字段 会生成相应的getter和setter方法。这两个方法是公有的，因为我们没有将age声明为private
  // 在Scala中，getter和setter分别叫做age和age_=
}
// 可以重新定义getter 和 setter方法
class Person2{
  private var privateAge = 0 //变成私有改名
  def age = privateAge
  def age_=(newValue:Int): Unit ={
    if(newValue>privateAge) privateAge=newValue
  }
}
// --------------------------只带getter属性---------------------------------------
class Person3{
  // val 字段修饰变量，scala会生成一个私有final字段和一个getter字段，但没有setter.
  val timeStamp = new java.util.Date
}

// 不过有时候你需要一个这样的属性，客户端不能随意该值，但它可以通过某种其他的方式被改变。
class Person4{
  private var age=0
  def increment(){age+=1}
  def current=age // 声明中无 （）
}

/**
 * 总结一下，在实现属性时你有如下四个选择
 * 1. var foo:Scala 自动合成一个getter 和  一个setter.
 * 2. val foo:Scala 自动合成一个getter
 * 3. 由你来定义foo和foo_=方法
 * 4. 由你来定义foo方法
 */


/**
 * 如果字段是私有的，则getter和setter方法也是私有的
 * 如果字段是val，则只有getter方法
 * 如果你不需要任何getter或setter，可以将字段声明为private[this]
 */
object section5_1 {
  def main(args: Array[String]): Unit = {
    // 使用类需要构造对象并按照通常的方式调用
    val mycounter = new Counter()
    // 我们认为对于该值器方法(即改变对象状态的方法）使用（），而对于取值器方法（不会改变对象状态的方法） 去掉（）是不错的风格
    mycounter.increment() //改值器
    print(mycounter.current) //取值器

    val person = new Person()
    print(person.age)
    person.age=21
    val person2 = new Person2()
    person2.age=30
    person2.age=21 // 不起作用 因为年龄不能改年轻


  }

}
