package dians.project.mapket.service;

import dians.project.mapket.model.Municipality;

import java.util.List;
import java.util.Optional;

public interface MunicipalityService {
    List<Municipality> findAll();
    Optional<Municipality> findById(Long id);
    Optional<Municipality> findByName(String name);
    void deleteById(Long id);
}
