

import scala.concurrent.{Promise, Await, Future}
import scala.util._
import scala.concurrent.duration._
/**
  * Created by gaoxd on 2018/5/25.
  */

object testFuturePromise {
  def main(args: Array[String]) {
    import scala.concurrent.ExecutionContext.Implicits.global
    //   http://www.playscala.cn/doc/catalog?_id=j1_21

    val f = Future{ 1 + 2 }
    f.onComplete{ t =>
      t match{
        case Success(v) => println("success: " + v)
        case Failure(t) => println("failed: " + t.getMessage)
      }
    }
    //等待任务结束
    Await.ready(f, 10 seconds)

    println("============================================================")
    val f1 = Future{ 1 + 2 }
    val f2 = Future{ 3 / 0 }
    val f3 =
      for {
        v1 <- f1
        v2 <- f2
      } yield {
        v1 + v2
      }

    f3.onComplete{ t =>
      t match{
        case Success(v) => println("success: " + v)
        case Failure(t) => println("failed: " + t.getMessage)
      }
    }

    //等待任务结束
    Await.ready(f3, 10 seconds)

    println("-----------------------------------------------promise")
    val p = Promise[Int]()
    val fd = p.future
    for (v <- fd) { println("v="+v) }

    //3秒钟之后返回3
    Thread.sleep(3000)
    p.success(3)

    //等待任务结束
    Await.ready(f, 10 seconds)

    println("==================================copy")
    case class Dollar(value: Double)
    val amount = Dollar(100.0)
    println(amount)
    val newAmound = amount.copy(value = 1000.0)
    println(newAmound)
  }


}
