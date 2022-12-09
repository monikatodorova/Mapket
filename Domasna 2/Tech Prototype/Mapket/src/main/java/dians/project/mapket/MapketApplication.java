package dians.project.mapket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MapketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapketApplication.class, args);
    }

}
