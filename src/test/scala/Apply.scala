class Apply{
  def apply() = println("我在学习Spark。")

  def haveATry{
    println("Have a try on apply!")
  }
}

object Apply{
  def apply() = {
    println("我在学习Scala。")
    new Apply    //返回Apply类的对象实例
  }
}

object ApplyTest {
  def main(args: Array[String]): Unit = {
    val array = Array(1,2,3,4,5)

    //类名后加括号，相当于调用伴生对象的apply方法
    val a = Apply()
    a.haveATry
    println

    //对象加括号相当于调用对象的apply方法
    println(a())
  }
}
