package dians.project.mapket.service.impl;

import dians.project.mapket.model.Market;
import dians.project.mapket.model.Municipality;
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

        return marketRepository.findMarketsByNameContainsIgnoreCaseOrNameEnContainsIgnoreCase(name, name);
    }

    @Override
    public List<Market> findByMunicipality(Long id) {
        return marketRepository.findMarketsByMunicipality_Id(id);
    }

    @Override
    public List<Market> findByNameAndMunicipality(String name, Long id) {
        return marketRepository.findMarketsByNameContainsIgnoreCaseAndMunicipality_IdOrNameEnContainsIgnoreCaseAndMunicipality_Id(name, id, name, id);
    }

    @Override
    public Market save(String name, double coordinatesLon, double coordinatesLat, String address, String workingHours,
                       String website, String nameEn, String addressEn, Municipality municipality) {
        return marketRepository.save(new Market(name, coordinatesLon, coordinatesLat, address,
                workingHours, website, nameEn, addressEn, municipality));
    }

    @Override
    public void deleteById(Long id) {
        marketRepository.deleteById(id);
    }
}
