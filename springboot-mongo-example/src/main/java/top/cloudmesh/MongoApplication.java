package top.cloudmesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * use test
 * db.createUser(
 *  {
 *    user: "test",
 *    pwd: passwordPrompt(),
 *    roles: [
 *       { role: "readWrite", db: "test" }
 *    ]
 *  }
 * )
 */
@SpringBootApplication
public class MongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

}