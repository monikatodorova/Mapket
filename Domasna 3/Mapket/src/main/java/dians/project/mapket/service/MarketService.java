package dians.project.mapket.service;

import dians.project.mapket.model.Market;
import dians.project.mapket.model.Municipality;

import java.util.List;
import java.util.Optional;

public interface MarketService {
    List<Market> findAll();
    Optional<Market> findById(Long id);
    List<Market> findByName(String name);
    List<Market> findByMunicipality(Long id);
    List<Market> findByNameAndMunicipality(String name, Long id);
    Market save(String name, double coordinatesLon, double coordinatesLat, String address,
                String workingHours, String website, String nameEn, String addressEn, Municipality municipality);
    void deleteById(Long id);
}
