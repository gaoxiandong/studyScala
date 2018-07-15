package testGuice.exampleProvide;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * v1.0:20161114
 * Provider绑定.
 * 如果建对象的过程很复杂,我们就会考虑,是不是可以把它独立出来,形成一个专门的类,基于这个思想,
 * Guice提供了一个接口Provider,Provider就像 Factories一样创建和返回对象.
 * 在大部分情况下,客户端可以直接依赖Guice框架来为服务(Services)创建依赖的对象.
 * 但是少数情况下,应用程序需要为一个特定类型的对象定制创建流程(Object creation process),
 * 这样可以控制对象创建的数量,提供缓存(Cache)机制等,基于这种需求,Guice提供了Provider类.
 * 只要实现Provider接口,就会得到专门为创建相应类型对象所需的类.
 */
public class MainTest {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MyModule());
        MyService myService = injector.getInstance(MyService.class);
        myService.service("Hello Guice!");
    }
}
/**
 ===>Hello Guice!
 */