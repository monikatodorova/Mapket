package dians.project.mapket.service.impl;

import dians.project.mapket.model.Municipality;
import dians.project.mapket.repository.MunicipalityRepository;
import dians.project.mapket.service.MunicipalityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MunicipalityServiceImpl implements MunicipalityService {
    public final MunicipalityRepository municipalityRepository;

    public MunicipalityServiceImpl(MunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }

    @Override
    public List<Municipality> findAll() {
        return municipalityRepository.findAll();
    }

    @Override
    public Optional<Municipality> findById(Long id) {
        return municipalityRepository.findById(id);
    }

    @Override
    public Optional<Municipality> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }
}
