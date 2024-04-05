package dmytro.bozhor.bpp;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
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

    @SneakyThrows
    private static void injectDummyString(Object bean, Field field) {
        field.setAccessible(true);
        field.set(bean, new String("123"));
        field.setAccessible(false);
        System.out.println("Dummy injected");
    }
}
