package testClass

/**
  * Created by gaoxd on 2018/5/27.
  */
//主构造器里面的东西都会执行
class Person {
  //类变量默认是public的,会生成name,id等get方法,var的还会生成set方法
  val id = "12345"
  var name = "gxd"
  println("朱构造器里面name="+name)
  //private的变量只有类似java,伴生对象里面可以访问
  private var gender: String = _  //不想初始化,可以用占位符初始化,系统会根据类型赋初值,在方法里面不行
                                  //但是val如果也用这种方法,会报错unbound placeholder parameter
  //private[this],伴生对象里面也不能访问,只能在class里面访问或者class里面的方法访问
  private[this] var pop:String = _

  //private[testClass],pacage里面都可以访问
  private[testClass] var pacage1:String = _

  def testPop: Unit ={
    println("pop="+pop)
  }

}

//伴生对象,单例的,里面的方法相当于java的静态方法,里面的变量也是静态的,如果是私有的,那就是常量了
object Person {
  val ddd = "ddd"   //常量
  var eee:Int = _

  def main(args: Array[String]) {
//    var ddd1:Int = _    //方法里面不行
    val person = new Person
    println(person.id + " "+person.name)
//    person.id = "12321" //不行 val不能修改
    person.name = "gxd1"
    println(person.id + " "+person.name)
    println("gender="+person.gender)
    println("pacage1="+person.pacage1)
//    println("pop="+person.pop ) //不能访问pop变量
    person.testPop
  }
}

object AAA {
  def main(args: Array[String]) {
    val person = new Person
    println(person.id + " "+person.name)
    //    person.gender  //不行
  }
}

class gril{

}