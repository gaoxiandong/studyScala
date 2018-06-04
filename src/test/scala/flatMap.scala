/**
  * Created by gaoxd on 2018/5/10.
  */
object flatMap {
  def main(args: Array[String]) {
  val abcd = Seq('a', 'b', 'c', 'd')
  //List(A, a, B, b, C, c, D, d)
    println(abcd)
    val ddd2 = abcd.map(ch => ch.toUpper)
    println(ddd2)
    //flatMap 是先做map再做flatten
  val ddd1 = abcd.flatMap(ch => List(ch.toUpper, ch))
    println(ddd1)

  val array = Array(1,2,3,4,5)
  val aa = array.fold(1)((res,n) => res + n)
  println(aa)

  val numbers = Seq(1,2,3,4,5)
  val a = numbers.fold(3)((res,n) => res + n)
  println(a)
  val b = numbers.foldLeft(3)((res,n) => res + n)
  println(b)
  val c = numbers.foldRight(3)((res,n) => res + n)
  println(c)
}
}
