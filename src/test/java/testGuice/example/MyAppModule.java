package testGuice.example;

import com.google.inject.AbstractModule;

/**
 * Created by gaoxd on 2018/7/2.
 * https://blog.csdn.net/u011054333/article/details/57179999
 */
public class MyAppModule extends AbstractModule {
    @Override
    protected void configure() {
        //链式绑定
        bind(LogService.class).to(LogServiceImpl.class);
        bind(UserService.class).to(UserServiceImpl.class);
        bind(Application.class).to(MyApp.class);
    }
}