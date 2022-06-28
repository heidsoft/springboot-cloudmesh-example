package top.cloudmesh;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 127.0.0.1:6379> SMEMBERS set_sample
 * 1) "\"c++\""
 * 2) "\"java\""
 * 3) "\"rust\""
 * 127.0.0.1:6379>
 * @author heidsoft
 */
@SpringBootApplication
@ComponentScan(basePackages = "top.cloudmesh")
public class RedisApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}
