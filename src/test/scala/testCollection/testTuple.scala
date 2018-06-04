package testCollection

import scala.collection.mutable.ArrayBuffer

/**
  * Created by gaoxd on 2018/5/26.
  */
object testTuple {
  def main(args: Array[String]) {
    val tt = (3,"ddd",4.56)
    println(tt)
    println(tt._1)

    val (x,y,z) = tt
    println(x)
    println(y)
    println(z)

    //拉链操作 zip
    val aa = ArrayBuffer("11","2a","3b",5,6)
    val bb = ArrayBuffer(1,2,3,4,"d")
    val cc = aa.zip(bb)
    println(cc)
  }
}
