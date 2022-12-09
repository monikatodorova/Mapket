package dians.project.mapket.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String name;

    public double coordinatesLon;

    public double coordinatesLat;

    public String address;

    public String workingHours;
    public String website;

    @OneToOne
    public Municipality municipality;

    public Market(String name, double coordinatesLon, double coordinatesLat, String address, String workingHours, String website) {
        this.name = name;
        this.coordinatesLon = coordinatesLon;
        this.coordinatesLat = coordinatesLat;
        this.address = address;
        this.workingHours = workingHours;
        this.website = website;
    }

    public Market() {

    }
}
