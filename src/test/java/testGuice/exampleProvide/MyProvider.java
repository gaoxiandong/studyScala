package testGuice.exampleProvide;

/**
 * Created by gaoxd on 2018/7/2.
 */
import com.google.inject.Provider;

public class MyProvider implements Provider<MyService>{

    @Override
    public MyService get() {
        MyService myService = new MyServiceImpl();
        return myService;
    }
}