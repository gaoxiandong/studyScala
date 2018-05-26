/**
  * Created by gaoxd on 2018/5/25.
  */
object testList {
  def main(args: Array[String]) {
    //-----------------------list
    val list = List(1, 3, 2, 4)
    //获取第1个元素
    println(list.headOption.getOrElse(0)) // 1
    //查找
    println(list.find(_ % 2 == 0).getOrElse(0)) // 2
    //过滤
    println(list.filter(_ % 2 == 1)) // List(1, 3)
    //排序
    list.sorted // List(1, 2, 3)
    //最小值/最大值/求和
    list.min // 1
    list.max // 3
    list.sum // 6
    //转化成字符串
    list.mkString(",") // "1, 3, 2"

    //----------------tuple
    val t = ("a", 1) // 等价于：val t: Tuple2[String, Int] = ("a", 1)
    println("t._1="+t._1) // "a"
    println("t._2="+t._2) // 1
//    println("t._3="+t._3)
  }
}
