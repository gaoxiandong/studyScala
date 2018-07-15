import java.io.{InputStream, File}
import java.util.zip.ZipEntry

import org.zeroturnaround.zip.commons.IOUtils
import org.zeroturnaround.zip.{ZipInfoCallback, ZipEntryCallback, ZipUtil}

/**
  * Created by gaoxd on 2018/6/25.
  */
class testZip {

}

object  testZip{
  def main(args: Array[String]) {
    ZipUtil.iterate(new File("/Users/gaoxd/Downloads/wo.jpeg.zip"), new ZipEntryCallback {
      override def process(in:InputStream , zipEntry:ZipEntry ) {
        if (zipEntry.getName().endsWith(".jpeg")) {
          println("Found " + zipEntry.getName());
//          IOUtils.copy(in, System.out);
        }
      }
    });

    ZipUtil.iterate(new File("/Users/gaoxd/Downloads/wo.jpeg.zip"), new ZipInfoCallback {
      override def process(zipEntry: ZipEntry): Unit = {
        if(zipEntry.isDirectory){
          println(s"${zipEntry.getName} is directory")
//          zipEntry.get
        }else{
          println(s"${zipEntry.getName} is file")
        }
      }
    })

    ZipUtil.unpack(new File("/Users/gaoxd/Downloads/wo.jpeg.zip"),new File("/Users/gaoxd/Downloads/test"))


  }
}