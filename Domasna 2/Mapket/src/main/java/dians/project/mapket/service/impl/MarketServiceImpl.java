package dians.project.mapket.service.impl;

import dians.project.mapket.model.Market;
import dians.project.mapket.repository.MarketRepository;
import dians.project.mapket.service.MarketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarketServiceImpl implements MarketService {

    public final MarketRepository marketRepository;

    public MarketServiceImpl(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @Override
    public List<Market> findAll() {
        return marketRepository.findAll();
    }

    @Override
    public Optional<Market> findById(Long id) {
        return marketRepository.findById(id);
    }

    @Override
    public List<Market> findByName(String name) {
        return marketRepository.findMarketsByNameContainsIgnoreCase(name);
    }

    @Override
    public List<Market> findByMunicipality(Long id) {
        return marketRepository.findMarketsByMunicipality_Id(id);
    }

    @Override
    public List<Market> findByNameAndMunicipality(String name, Long id) {
        return marketRepository.findMarketsByNameContainsIgnoreCaseAndMunicipality_Id(name, id);
    }

    @Override
    public Market save(String name, double coordinatesLon, double coordinatesLat, String address, String workingHours, String website) {
        return marketRepository.save(new Market(name, coordinatesLon, coordinatesLat, address, workingHours, website));
    }

    @Override
    public void deleteById(Long id) {
        marketRepository.deleteById(id);
    }
}
