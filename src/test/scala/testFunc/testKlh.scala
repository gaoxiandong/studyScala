package testFunc

/**
  * Created by gaoxd on 2018/6/9.
  */
object testKlh {
  //两种方式的柯里化
  def fun1(x:Int)(y:Int) = x * y
  def fun2(x:Int) = (y:Int) => x * y

  def main(args: Array[String]) {
    val list = Array(1,2,3,4,5)
    val dd = list.map(fun1(2))
    val ff = list.map(fun2(2))
    println(dd.toBuffer)
    println(ff.toBuffer)
  }
}
