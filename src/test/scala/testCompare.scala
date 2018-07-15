/**
  * Created by gaoxd on 2018/6/26.
  */
class testCompare {

}

case class Person(val name:String,val age:Int) extends Ordered[Person] {
  override def compare(that: Person): Int = {
    if (this.name == that.name) {
      if (this.age > that.age)
        1
      else
        -1
    } else {
      if (this.name > that.name)
        1
      else
        -1
    }
  }
}

object testCompare{
  def main(args: Array[String]) {
    val p1=Person("cat",23)
    val p2=Person("dog",23)
    val p3=Person("andy",25)
    val p4=Person("andy",26)
    val p5=Person("cat",21)

    val pairs = Array(p1,p2,p3,p4,p5)

    //先按年龄排序，如果一样，就按照名称降序排
    val bx= pairs.sortBy(person => (person.age, person.name))( Ordering.Tuple2(Ordering.Int, Ordering.String.reverse) )

    bx.map(
      println
    )


    println("===============")
    val b=pairs.sortWith{
      case (person1,person2)=>{
        person1.age==person2.age match {
          case true=> person1.name>person2.name //年龄一样，按名字降序排
          case false=>person1.age<person2.age //否则按年龄升序排
        }
      }
    }
    b.map(
      println
    )
println("===============")
    val c=pairs.sortWith(_>_)
    c.map(
      println
    )


  }
}
