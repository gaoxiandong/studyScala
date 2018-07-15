package testOption

/**
  * Created by gaoxd on 2018/6/5.
  */
object testOption {
  def main(args: Array[String]) {
    val opt = Some("hahaha")
    val temp = opt.map(e => if(e.equals("hahaha")) "ddd" else None).getOrElse()

    val opt1 = Some("hahaha1")
    val temp1 = opt1.map(e => if(e.equals("hahaha")) "ddd" else None).getOrElse()

    println(temp)
    println(temp1)
  }
}
