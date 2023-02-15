package dians.project.mapket.seeder;

import dians.project.mapket.repository.MarketRepository;
import dians.project.mapket.repository.MunicipalityRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DatabaseSeeder {
    @Autowired
    private MunicipalityRepository municipalityRepository;

    @Autowired
    private MarketRepository marketRepository;

    @PostConstruct
    public void run() throws IOException {
        MunicipalitySeeder municipalitySeeder = new MunicipalitySeeder(municipalityRepository);
        municipalitySeeder.seed();
        MarketSeeder marketSeeder = new MarketSeeder(marketRepository);
        marketSeeder.seed();
    }
}
