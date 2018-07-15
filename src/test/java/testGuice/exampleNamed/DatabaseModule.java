package testGuice.exampleNamed;

/**
 * Created by gaoxd on 2018/6/29.
 */
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class DatabaseModule extends AbstractModule {

    @Override
    protected void configure() {
        //实例绑定
        bind(String.class).annotatedWith(Names.named("driverClassName")).toInstance("com.mysql.jdbc.Driver");

        bind(String.class).annotatedWith(Names.named("url")).toInstance("jdbc:mysql://localhost:3306/demo");

        bind(String.class).annotatedWith(Names.named("username")).toInstance("root");

        bind(String.class).annotatedWith(Names.named("password")).toInstance("root");

        bind(Scope.class).annotatedWith(Names.named("scope")).toInstance(Scope.GLOBAL);

    }
}