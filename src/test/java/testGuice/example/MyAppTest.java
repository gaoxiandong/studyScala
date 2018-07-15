package testGuice.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by gaoxd on 2018/7/2.
 */
public class MyAppTest {
    private static Injector injector;

    @BeforeClass
    public static void init() {
        injector = Guice.createInjector(new MyAppModule());
    }

    @Test
    public void testMyApp() {
        Application myApp = injector.getInstance(Application.class);
        myApp.work();
    }
}

//程序结果
//我需要做一些业务逻辑
//------LOG:程序正常运行
