package dians.project.mapket.repository;

import dians.project.mapket.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
    List<Market> findMarketsByName(String name);
    List<Market> findMarketsByNameContains(String input);
    List<Market> findMarketsByNameContainsIgnoreCase(String input);
    List<Market> findMarketsByNameContainsIgnoreCaseOrNameEnContainsIgnoreCase(String input1, String input2);

    List<Market> findMarketsByNameContainsIgnoreCaseAndMunicipality_Id(String input, Long id);
    List<Market> findMarketsByNameContainsIgnoreCaseAndMunicipality_IdOrNameEnContainsIgnoreCaseAndMunicipality_Id(String input1, Long id1, String input2, Long id2);
    List<Market> findMarketsByMunicipality_Id(Long id);
}
