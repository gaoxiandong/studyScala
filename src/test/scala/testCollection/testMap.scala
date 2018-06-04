package testCollection

/**
  * Created by gaoxd on 2018/5/26.
  */
object testMap {
  def main(args: Array[String]) {

    //不可变Map---------------
    val map1 = Map("dd"->1,"ee"->2)
    println(map1("dd"))
    //map里面实际装的是个二元组
    val map2 = Map(("dd1",1),("ee1",2))
    println(map2("dd1"))
    //map1("dd")=2 //不行

    //合并
    println(map1 ++ map2)

    //可变Map-----------------
    import scala.collection.mutable.Map
    val map3 = Map("ff"->3)
    map3("ff")=4
    println(map3("ff"))

    map3.put("gg",5)
    println(map3)

    val pair = ("jj",8)
    map3 += pair

//    map3 += ("jjj",9) //不行
    map3 += (("jjj",9))

    println(map3.get("hh"))
    println(map3.getOrElse("hh",10))
//    println(map3("hh")) //报错

    map3 -= ("jjj")

    //转成List
    val mapToList = map3.toList
    println(mapToList)

//    var mapvar:Int = _    //这个是不行的
  }

}
