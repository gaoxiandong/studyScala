package testClass

/**
  * Created by gaoxd on 2018/5/27.
  */
class testObject {

}


//单例对象的名字如何和类名相同,就是伴生对象
object testObject{
  def apply(): testObject ={
    println("apply exec")
    //可以返回对象
    new testObject
  }
  def apply(name:String): Unit ={
    println("name="+name)
  }
  def main(args: Array[String]) {
    val testO = testObject  //单例对象
    println(testO)

    val testOO = testObject() //调用了apply
    println(testOO)

    val testOO1 = testObject("123") //调用了apply
    println(testOO1)  //()就是Unit
  }
}

//单例对象也可以继承,如果继承App,可以省略main
object testApp extends App{
  println("i am testApp,可以省略main")
}