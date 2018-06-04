package testClass

/**
  * Created by gaoxd on 2018/5/27.
  */
//主构造器写在类定义里面,gender相当于private[this],age默认值传
class testConstruction(val id:Int,var name:String,gender:String,val age:Int = 18) {
  var score:Int = _
  //构造器重载,辅助构造器
  def this(score:Int){
    //必须要先执行主构造器
    this(123,"gxd","male")
    this.score = score;
    println(this.score)

  }
}

object testConstruction{
  def main(args: Array[String]) {
    val testCon = new testConstruction(123,"gxd","mail")
    println(testCon.age)
    val testFZ = new testConstruction(456)
    println(testFZ.score)
  }
}