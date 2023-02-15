package dians.project.mapket.seeder;

import dians.project.mapket.helpers.MunicipalityReader;
import dians.project.mapket.model.Municipality;
import dians.project.mapket.repository.MunicipalityRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class MunicipalitySeeder {
    private final MunicipalityRepository municipalityRepository;

    public MunicipalitySeeder(MunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }

    public void seed() throws IOException {
        if(!municipalityRepository.findAll().isEmpty()) {
            return;
        }
        List<Municipality> municipalites = MunicipalityReader.getAllMunicipalities();
        municipalityRepository.saveAll(municipalites);
    }
}
