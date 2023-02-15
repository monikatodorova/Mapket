package dians.project.mapket.helpers;

import dians.project.mapket.model.Municipality;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class MunicipalityReader {

    private static InputStream INPUT_FILE;

    public MunicipalityReader() {
        MunicipalityReader.INPUT_FILE = getClass().getClassLoader().getResourceAsStream("data/municipalities.csv");
    }

    public static List<Municipality> getAllMunicipalities() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(INPUT_FILE, StandardCharsets.UTF_8));
        List<Municipality> municipalities = new ArrayList<>();
        String line = br.readLine();
        while(true) {
            line = br.readLine();
            if(line == null) break;
            String[] parts = line.split(",");
            Municipality municipality = new Municipality(parts[1], parts[2]);
            municipalities.add(municipality);
        }
        return municipalities;
    }

}
