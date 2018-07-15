package testGuice.example;

/**
 * Created by gaoxd on 2018/7/2.
 */
public class UserServiceImpl implements UserService {
    @Override
    public void process() {
        System.out.println("我需要做一些业务逻辑");
    }
}
