package chapter05
// --------------------------对象私有字段---------------------------------------
// 在scala中，方法可以访问该类的所有对象的私有字段。
class Person5_2{
  private var age = 10
  def increment(){age+=1}
  // 之所以访问other.age 是合法的，是因为other同样是Person5_2对象
  def isLess(other:Person5_2) = age<other.age // 可以访问另一个对象的私有字段
  // 如果不想让同类对象访问 可以使用以下方式
  private[this] var age2 = 10
}

// --------------------------辅助构造器---------------------------------------
// Scala类有一个构造器比其它所有构造器更为重要，他就是主构造器，除了主构造器之外，类还可以有任意多的辅助构造器。
/**
 * 1.辅助构造器的名称为 this
 * 2.每一个辅助构造器都必须以一个对先前已定义的其它辅助构造器或主构造器的调用开始
 * 3.一个类如果没有显式定义主构造器，则自动拥有一个无参的主构造器
 */
class ZhangSan {
  private var age = ""
  private var height = 170
  def this(age:String){ // 一个辅助构造器
    this() //调用主构造器
    this.age = age
  }
  def this(age:String,height:Int){
    this(age) //调用前一个构造器
    this.height=height
  }
}

object section5_2 {
  def main(args: Array[String]): Unit = {
    val person = new Person5_2()
    val person2 = new Person5_2()
    person2.increment()
    print(person.isLess(person2))
    val zs1 = new ZhangSan() //主构造器
    val zs2 = new ZhangSan("19") // 第一个辅助构造器
    val zs3 = new ZhangSan("19",180) //第三个辅助构造器


  }

}
