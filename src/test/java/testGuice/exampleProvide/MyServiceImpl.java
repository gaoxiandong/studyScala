package testGuice.exampleProvide;

/**
 * Created by gaoxd on 2018/7/2.
 */
public class MyServiceImpl implements MyService {

    public void service(String service) {
        System.out.println("===>" + service);
    }
}
