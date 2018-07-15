package testImplicit

/**
  * 隐式转换  隐式参数  隐式类
  */

//隐式转换
class TestImplicit(a: A) {
  def Test: Unit = {
    println("Implicit")
  }
}

class A {

}

object TestImplicit {
  //隐式转换(隐式调用函数)
    // 隐式调用函数可以转换调用方法的对象，比如但编译器看到X .method，而类型 X 没有定义 method（包括基类)方法，
    // 那么编译器就查找作用域内定义的从 X 到其它对象的类型转换，比如 Y，而类型Y定义了 method 方法，编译器就首先使用隐含类型转换把 X 转换成 Y，
    // 然后调用 Y 的 method。
  implicit def a2Implicit(a: A) = new TestImplicit(a)

  //隐式参数
    //当我们在定义方法时，可以把最后一个参数列表标记为implicit，表示该组参数是隐式参数。
    //一个方法只会有一个隐式参数列表，置于方法的最后一个参数列表。
    //如果方法有多个隐式参数，只需一个implicit修饰即可。
    //当调用包含隐式参数的方法是，如果当前上下文中有合适的隐式值，则编译器会自动为改组参数填充合适的值。
    //如果没有编译器会抛出异常。当然，标记为隐式参数的我们也可以手动为该参数添加默认值。
  def ImplicitMethod(implicit name: String,age: Int): Unit = {
    println(s"name=$name,age=$age")
  }
  def ImplicitMethodOneImplicitPara(age: Int)(implicit name: String): Unit = {
    println(s"name=$name,age=$age")
  }

  //隐式类
  implicit class JiSuan(x: Int) {
    def add(a: Int): Int = a + 1
  }

  //上下文绑定
  def maxListOrdering[T: Ordering](elements: List[T]): T =
  elements match {
    case List() =>
      throw new IllegalArgumentException("empty lists!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxListOrdering(rest)
      if (implicitly[Ordering[T]].gt(x, maxRest)) x
      else maxRest
  }

//  def maxListOrdering[T](elements: List[T])
//                        (implicit ordering: Ordering[T]): T =
//    elements match {
//      case List() =>
//        throw new IllegalArgumentException("empty lists!")
//      case List(x) => x
//      case x :: rest =>
//        val maxRest = maxListOrdering(rest)
//        if (ordering.gt(x, maxRest)) x
//        else maxRest
//    }

  def main(args: Array[String]) {
    //隐式转换
    val a = new A
    a.Test

    //隐式地转换类型
    //使用隐含转换将变量转换成预期的类型是编译器最先使用 implicit 的地方。
    // 这个规则非常简单，当编译器看到类型X而却需要类型Y，它就在当前作用域查找是否定义了从类型X到类型Y的隐式定义
    implicit def double2Int(d: Double) = d.toInt
    val i: Int = 3.5
    println(s"i=$i")

    println("======================")

    //隐式参数
    implicit val name1 = "hark"
    implicit val age1 = 4
    ImplicitMethod
    ImplicitMethod("kxy",5)

    ImplicitMethodOneImplicitPara(4)
    ImplicitMethodOneImplicitPara(5)("kxy")

    println("======================")

    //隐式类
    println(4.add(2))

    println("======================")

    //上下文绑定
    println(maxListOrdering(List(1, 5, 10, 3)))

  }

}