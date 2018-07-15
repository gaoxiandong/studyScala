package testGuice.exampleNamed;

/**
 * Created by gaoxd on 2018/6/29.
 */
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Google Guice提供了一个名为@Singleton的注解，只要在类上加上这个注解，
// 就可以实现一个单例类，不需要自己手动编写单例实现类。@Named注解提供了为属性赋值的功能。

public class testNamed {
    private static Logger logger = LoggerFactory.getLogger(testNamed.class);

    public static void main(String[] args) {
        Module module = new DatabaseModule();
        Injector injector = Guice.createInjector(module);
        Database instance1 = injector.getInstance(Database.class);
        Database instance2 = injector.getInstance(Database.class);

        logger.info("driverClassName is " + instance1.driverClassName());
        logger.info("url is " + instance1.url());
        logger.info("username is " + instance1.username());
        logger.info("password is " + instance1.password());

        Boolean isSingleton = instance1.equals(instance2);
        logger.info(instance1.toString());
        logger.info(instance2.toString());
        logger.info(isSingleton.toString());
    }

}