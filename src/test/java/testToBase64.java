import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * Created by gaoxd on 2018/5/30.
 */
public class testToBase64 {
    public static void main(String[] args){
        System.out.println(testToBase64.encryptToBase64("/Users/gaoxd/Downloads/ob_KO4j_nKjsFGP8STpyafp3okS0/4e1339ddb531632c65ec2f44f6895d07.mp4"));
    }
    public static String encryptToBase64(String filePath) {
        if (filePath == null) {
            return null;
        }
        try {
            byte[] b = Files.readAllBytes(Paths.get(filePath));
            return Base64.getEncoder().encodeToString(b);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
