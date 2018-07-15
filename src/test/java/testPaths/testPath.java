package testPaths;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by gaoxd on 2018/7/3.
 */
public class testPath {
    public static void main(String[] args) throws FileNotFoundException {
//        Path ddd = Paths.get("郜宪东.xlsx").getFileName();
        System.out.println(DigestUtils.md5Hex("autosos"));
        FileInputStream fileInputStream = new FileInputStream(new File("/opt/face-attendance/tmp/公司员工face.xlsx"));
        System.out.println(fileInputStream);

    }
}
