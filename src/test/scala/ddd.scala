import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

/**
  * Created by gaoxd on 2018/5/2.
  */
object ddd {
  def main(args: Array[String]) {

    var errMessage = ""
    val f = Future{ 3/1 }
    f.onComplete{ t =>
      t match{
        case Success(v) => println("success: " + v)
        case Failure(t) => {
          println("failed: " + t.getMessage)
          errMessage=t.getMessage
        }
      }
    }
    //等待任务结束
    Await.ready(f, 10 seconds)

    if(errMessage.nonEmpty)
      println(""+errMessage)
    else
      println("sss")

  }
}
