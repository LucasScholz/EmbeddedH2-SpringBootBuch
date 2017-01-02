package de.springbootbuch.embedded_h2;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {
    
    @RestController
    public static class Endpoint {
        
        private final JdbcTemplate jdbcTemplate;

        public Endpoint(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }
        
        @GetMapping("/springDataModules")
        public List<String> getSpringDataModules() {
            return this.jdbcTemplate.queryForList(
                    "Select name from spring_data_modules order by name asc", 
                    String.class
            );
        }
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}