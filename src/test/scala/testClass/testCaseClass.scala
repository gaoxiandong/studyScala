package testClass

/**
  * Created by gaoxd on 2018/6/20.
  */
case class testCaseClass(field:String,field2:Int,field3:Option[String]) {
  def asEntityDto = Map(
    "field" -> this.field,
    "field2" -> this.field2,
    "field3" -> this.field3.getOrElse("")
  )
}

object testCaseClass{
  def main(args: Array[String]) {
    val t = testCaseClass("sdfas",123,Some("ewr"))

    println(t.asEntityDto)

    val _t=t.copy(field = "ddd")

    println(_t.asEntityDto)
  }
}