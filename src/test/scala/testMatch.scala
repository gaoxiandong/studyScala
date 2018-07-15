/**
  * Created by gaoxd on 2018/7/4.
  */
object testMatch {
  def main(args: Array[String]) {
    val all = "0"

    val ddd = "0"
    ddd match {
      case `all` => println("all")
      case _ => println("1")
    }

  }
}
