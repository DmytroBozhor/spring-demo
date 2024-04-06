package dmytro.bozhor.bpp;

import dmytro.bozhor.ConnectionPool;
import dmytro.bozhor.Proxyable;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class DummyPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("DummyBeanPostProcessor has been invoked");

        var declaredFields = bean.getClass().getDeclaredFields();
        Arrays.stream(declaredFields)
                .filter(field -> field.isAnnotationPresent(InjectDummy.class))
                .forEach(field -> injectDummyString(bean, field));


        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return Proxy.newProxyInstance(ConnectionPool.class.getClassLoader(), new Class[]{Proxyable.class}, (proxy, method, args) -> {
            System.out.println("Proxy starts");
            var object = method.invoke(bean, args);
            System.out.println("Proxy ends");
            return object;
        });
    }

    @SneakyThrows
    private static void injectDummyString(Object bean, Field field) {
        field.setAccessible(true);
        field.set(bean, new String("123"));
        field.setAccessible(false);
        System.out.println("Dummy injected");
    }
}
