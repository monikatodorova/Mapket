package dians.project.mapket.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Municipality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String name;
    public String nameEn;
    @OneToMany(fetch=FetchType.EAGER)
    public List<Market> marketsList;

    //public double coordinatesLon;
    //public double coordinatesLat;

    public Municipality(String name, String nameEn) {
        this.name = name;
        this.nameEn = nameEn;
        this.marketsList = new ArrayList<>();
        //this.coordinatesLon = coordinatesLon;
        //this.coordinatesLat = coordinatesLat;
    }

    public Municipality() {

    }
}
