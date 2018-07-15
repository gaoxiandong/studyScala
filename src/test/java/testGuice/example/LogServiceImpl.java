package testGuice.example;

/**
 * Created by gaoxd on 2018/7/2.
 */
public class LogServiceImpl implements LogService {
    @Override
    public void log(String msg) {
        System.out.println("------LOG:" + msg);
    }
}
