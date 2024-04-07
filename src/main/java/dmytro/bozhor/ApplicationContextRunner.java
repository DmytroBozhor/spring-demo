package dmytro.bozhor;

import dmytro.bozhor.config.GlobalConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextRunner {
//    private static final String PACKAGE_FOR_SCAN = Path.of("dmytro", "bozhor").toString();

    public static void main(String[] args) {

//        Without closing the bean container no destroy method will be called on singleton beans
        try (var container = new AnnotationConfigApplicationContext(GlobalConfiguration.class)) {

            var connectionPoolBean = (ConnectionPool) container.getBean("connectionPool");
            System.out.println("Connection pool bean obtained");

            connectionPoolBean.printHello();

            var connectionPoolTwo = container.getBean("connectionPoolTwo");
            System.out.println(connectionPoolTwo);


        }


    }
}