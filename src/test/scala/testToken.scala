import org.apache.commons.codec.digest.DigestUtils
/**
  * Created by gaoxd on 2018/6/5.
  */
class testToken {

}

object testToken {
  val DEFAULT_USERNAME = "admin"
  val DEFAULT_PASSWORD = "admin"
  val DEFAULT_TOKEN = genToken(DEFAULT_USERNAME, DEFAULT_PASSWORD)

  def genToken(username: String, password: String) = DigestUtils.md5Hex(s"$username:$password")

  def main(args: Array[String]) {
    println(DEFAULT_TOKEN)
  }

}