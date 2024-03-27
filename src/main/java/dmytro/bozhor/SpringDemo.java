package dmytro.bozhor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.nio.file.Path;

public class SpringDemo {
    private static final String PACKAGE_FOR_SCAN = Path.of("dmytro", "bozhor").toString();

    public static void main(String[] args) {

//        Without closing the bean container no destroy method will be called on singleton beans
        try (var container = new AnnotationConfigApplicationContext(PACKAGE_FOR_SCAN)) {

            System.out.println(container.getBean(ConnectionPool.class));



        }


    }
}