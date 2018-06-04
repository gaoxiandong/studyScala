package testFunc

/**
  * Created by gaoxd on 2018/5/26.
  * def  的是方法
  * val 的是函数
  */
object twoMethodDefine {
  def main(args: Array[String]) {
    //第一种方式
    val func1 = (a:Int,b:Double) => {
      (b,a)
    }
    println(func1(2,3.0))

    //第二种方式
    val func2: (Int,Double) => (Double,Int) = {(a,b) => (b,a)}
    println(func2(2,3.0))

    //第三种方式
    def m2(a:Int,b:Int) = {
      a+b
    }

    val fun3 = m2 _   //方法变函数
    println(fun3(1,2))
  }

}
