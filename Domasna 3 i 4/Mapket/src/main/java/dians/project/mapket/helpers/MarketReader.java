package dians.project.mapket.helpers;

import dians.project.mapket.model.Market;
import dians.project.mapket.model.Municipality;
import dians.project.mapket.service.MunicipalityService;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class MarketReader {

    private static MunicipalityService municipalityService;
    private static InputStream INPUT_FILE;

    public MarketReader(MunicipalityService municipalityService) {
        MarketReader.municipalityService = municipalityService;
        MarketReader.INPUT_FILE = getClass().getClassLoader().getResourceAsStream("data/markets.csv");
    }

    public static List<Market> getAllMarkets() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(INPUT_FILE, StandardCharsets.UTF_8));
        List<Market> markets = new ArrayList<>();
        String line = br.readLine();
        while(true) {
            line = br.readLine();
            if(line == null) break;
            String[] parts = line.split(",");
            Municipality municipality = municipalityService.findById(Long.valueOf(parts[9])).orElse(null);
            Market market = new Market(parts[5], Double.parseDouble(parts[4]), Double.parseDouble(parts[3]), parts[1],
                    parts[8], parts[7], parts[6], parts[2], municipality);
            markets.add(market);
        }
        return markets;
    }

}
