package com.verge.infrastructure;

import com.verge.services.JsonConvertor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.data.repository.query.QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND;

@SpringBootApplication
@EnableJpaRepositories(value = "com.verge.repository", queryLookupStrategy = CREATE_IF_NOT_FOUND)
// Entities not found without this
@EntityScan("com.verge.entity")
// Controllers not found without this
@ComponentScan({"com.verge"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        migrateDB();
    }

    private static void migrateDB() {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost/footballApp", "root", null);
        flyway.migrate();
        JsonConvertor convertor = new JsonConvertor();
        convertor.createFields();
    }
}
