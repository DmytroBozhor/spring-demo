package dmytro.bozhor;

import org.springframework.stereotype.Component;

@Component
public class ConnectionPool {

    @PostConstract
    public void init(){
        System.out.println("Connection pool initialization");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Connection pool destroy");
    }

}
