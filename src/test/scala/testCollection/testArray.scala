package testCollection

/**
  * Created by gaoxd on 2018/5/26.
  * 数组不属于集合,集合有序列(seq)set,map组成
  */
object testArray {
  def main(args: Array[String]) {
    //定长数组---------------
    val a = new Array[Int](10)
    a(1) = 1
    println("a="+a.toBuffer)
    val b = Array(1,2,3)
    println("b="+b.toBuffer)

    //变长数组--------------------
    import scala.collection.mutable.ArrayBuffer
    val ab = new ArrayBuffer[Int]()
    ab += 1
    //追加元祖
    ab += (2,3,4)
    //追加数组
    ab ++= Array(5,6,7)
    //insert
    ab.insert(1,8,9)
    ab.remove(1,2)
    println("ab="+ab)

//    for (i <- ab.reverse){
//      println(i)
//    }
//
//    for (i <- (0 until ab.length).reverse){
//      println(ab(i))
//    }

    //map,filter
    val ab1 = ab.filter(_ % 2 == 0).map(_ * 10)
    println("ab1="+ab1)

    //sortBy sortWith
    val aa = ArrayBuffer(2,8,4,5,3,9)
    val ab2 = aa.sortBy(x => x)
    println("ab2="+ab2)
    val ab3 = aa.sortWith(_<_)
    println("ab3="+ab3)

    val ab4 = aa.sortWith(_>_)
    println("ab4="+ab4)

    val ab5 = aa.sortWith((x,y) => {x>y})
    println("ab5="+ab5)


  }

}
