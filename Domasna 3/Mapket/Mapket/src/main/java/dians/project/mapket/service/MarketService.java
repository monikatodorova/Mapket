package dians.project.mapket.service;

import dians.project.mapket.model.Market;

import java.util.List;
import java.util.Optional;

public interface MarketService {
    List<Market> findAll();
    Optional<Market> findById(Long id);
    List<Market> findByName(String name);
    List<Market> findByMunicipality(Long id);
    List<Market> findByNameAndMunicipality(String name, Long id);
    Market save(String name, double coordinatesLon, double coordinatesLat, String address,
                String workingHours, String website, String nameEn, String addressEn);
    void deleteById(Long id);
}
