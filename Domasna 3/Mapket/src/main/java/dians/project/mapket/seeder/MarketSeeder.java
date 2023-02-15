package dians.project.mapket.seeder;

import dians.project.mapket.helpers.MarketReader;
import dians.project.mapket.model.Market;
import dians.project.mapket.repository.MarketRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class MarketSeeder {
    private final MarketRepository marketRepository;

    public MarketSeeder(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public void seed() throws IOException {
        if(!marketRepository.findAll().isEmpty()) {
            return;
        }
        List<Market> markets = MarketReader.getAllMarkets();
        marketRepository.saveAll(markets);
    }
}
