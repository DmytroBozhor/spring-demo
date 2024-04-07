package dmytro.bozhor.config;

import dmytro.bozhor.ConnectionPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("dmytro.bozhor")
public class GlobalConfiguration {

    @Bean
    public ConnectionPool connectionPoolTwo() {
        return new ConnectionPool();
    }

}
