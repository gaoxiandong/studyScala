import java.io.File
import java.nio.file.Paths

/**
  * Created by gaoxd on 2018/6/25.
  */
class testFile {

}

object testFile{
  def main(args: Array[String]) {
    //路径
    //假设是Unix的文件系统
    val absolute = Paths.get("/home", "cat"); //绝对路径

    val relative = Paths.get("ixenos", "config", "user.properties"); //相对路径

    println(absolute)
    println(relative)
    //1) 调用 p.resolve(q) 将按下面的规则返回一个Path：如果q是绝对路径，则返回q，否则追加路径返回 p/q 或者 p\q
    println(absolute.resolve(relative))
    println(absolute.resolve("work"))
    //2) 调用 p.resolveSibling("q") 将解析指定路径 p 的父路径 o ，并产生兄弟路径 o/q
    println(absolute.resolveSibling("cat2"))

    //
    println(System.getProperty("user.dir"))

    val tempPath = System.getProperty("user.dir")+"/temp"
    val tempDir = new File(tempPath)
    if (!tempDir.exists()) {
      tempDir.mkdirs()
    }
  }
}
