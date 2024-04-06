package dmytro.bozhor;

import dmytro.bozhor.bpp.InjectDummy;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ConnectionPool implements Proxyable {

    @InjectDummy
    private String dummy;

    public ConnectionPool() {
        System.out.println("Connection pool constructor invocation");
    }

    @PostConstruct
    public void init(){
        System.out.println("Connection pool initialization");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Connection pool destroy");
    }

    public void printHello(){
        System.out.println("Hello from connection pool");
    }

}
