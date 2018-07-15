package testGuice.exampleNamed;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
// Google Guice提供了一个名为@Singleton的注解，只要在类上加上这个注解，就可以实现一个单例类，
// 不需要自己手动编写单例实现类。@Named注解提供了为属性赋值的功能。

@Singleton
public class Database {

    @Named("driverClassName")
    @Inject
    private String driverClassName;

    @Named("url")
    @Inject
    private String url;

    @Named("username")
    @Inject
    private String username;

    @Named("password")
    @Inject
    private String password;

    /**
     * Just for test and study,it does not make sense.
     */
    @Named("scope")
    @Inject
    private Scope scope;

    public String driverClassName() {
        return driverClassName;
    }

    public String url() {
        return url;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public Scope scope() {
        return scope;
    }
}