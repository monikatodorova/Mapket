package dians.project.mapket.repository;

import dians.project.mapket.model.Market;
import dians.project.mapket.model.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
}
