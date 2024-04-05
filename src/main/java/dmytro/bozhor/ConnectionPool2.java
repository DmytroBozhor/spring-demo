package dmytro.bozhor;

import dmytro.bozhor.bpp.InjectDummy;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ConnectionPool2 {

    @InjectDummy
    private String dummy;

    public ConnectionPool2() {
        System.out.println("Connection pool 2 constructor invocation");
    }

    @PostConstruct
    public void init(){
        System.out.println("Connection pool 2 initialization");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Connection pool 2 destroy");
    }

}
