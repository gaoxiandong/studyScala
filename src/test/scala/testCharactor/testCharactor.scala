package testCharactor

import com.sun.deploy.net.URLEncoder

/**
  * Created by gaoxd on 2018/6/5.
  */
object testCharactor {
  def main(args: Array[String]) {
    val temp = "大门"
    val utfS = URLEncoder.encode("大门", "utf-8");
    val gbkS = URLEncoder.encode("大门", "gbk");
    val ISO8859_1 = URLEncoder.encode("大门", "ISO8859_1");

    println(new String(gbkS.getBytes("gbk")))
    println(new String(utfS.getBytes("utf-8")))
    println(new String(ISO8859_1.getBytes("gb2312")))

    println("大门".getBytes("utf-8").toBuffer)
    println("大门".getBytes("gbk").toBuffer)
    println("大门".getBytes("ISO8859_1").toBuffer)

    val temp1 = new String(temp)
    val gbkS1 = new String(gbkS)

    println(temp1)
    println(gbkS1)
//    xmString = new String(sb.toString().getBytes("UTF-8"));
//    xmlUTF8 = URLEncoder.encode(xmString, "UTF-8");

  }
}
