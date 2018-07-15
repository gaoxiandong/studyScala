package testGuice.exampleProvide;

/**
 * Created by gaoxd on 2018/7/2.
 */
import com.google.inject.Binder;
import com.google.inject.Module;

public class MyModule implements Module{

    public void configure(Binder binder) {
        binder.bind(MyService.class).toProvider(MyProvider.class);
    }
}