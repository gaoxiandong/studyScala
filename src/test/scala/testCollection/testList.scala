package testCollection

import scala.collection.mutable.ListBuffer

/**
  * Created by gaoxd on 2018/5/25.
  */
object testList {
  def main(args: Array[String]) {
    //不可变-----------------------list
    val list = List(1, 3, 2, 4)
    val list0 = 0 :: list
    val list1 = list.+:(0)
    println(list0)
    println(list1)
    val list2 = 0 +: list
    println(list2)

    val list3 = Nil
    val list4 = list3 :+ 1
    println(list4)

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

    //可变LIst ---------------------------
    val lb = ListBuffer(1,2,3)
    lb(1)=5
    println(lb)
    lb += 6
    lb += (7,8,9)
    lb.append(12,22,23)
    lb ++= List(10,11)
    println(lb)

    lb ++ List(13,14,15) //lb不变化,会生成新的list
    println(lb)
//    lb += List(1,2)

    //sorted,grouped
    val lbsorted = lb.sorted
    println(lbsorted)

    val iter = lbsorted.grouped(3)
    val listGroup = iter.toList
    println(listGroup)
    println(iter.toList) //已经是空的了

    //flatten
    val flated = listGroup.flatten
    println(listGroup.flatten)

    //fold
    println(flated.fold(10)(_+_))
    //reduce
    println(flated.par.reduce(_+_))
    //sum
    println(flated.sum)

    val listT = ListBuffer(("aa",3),("aa",1),("aa",4))
    println(listT.foldLeft(0)(_+_._2))

  }
}
