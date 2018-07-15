package testEnum


/**
  * Created by gaoxd on 2018/6/1.
  */
object testEnum extends Enumeration{

    type testEnum = Value
    val user = Value(1, "user")
    val vip = Value(2, "vip")
    val blackList = Value(3, "bl")
    val visitor = Value(4, "visitor")
    val card = Value(5, "card")
    val stranger = Value(6, "stranger")
    val audio = Value(7, "audio")
    val face = Value(8, "face")

  def main(args: Array[String]) {
    println(testEnum.user.id)
    println(testEnum.user.toString)
    println(testEnum.user)
  }
}
