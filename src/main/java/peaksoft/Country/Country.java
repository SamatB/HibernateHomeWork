package peaksoft.Country;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "countries")
@Getter
@Setter
@ToString
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String capital;
    @Column
    private double area;
    @Column
    private int population;

    public Country() {
    }
}
