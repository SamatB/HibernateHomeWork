package peaksoft.Cars;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cars")
@Getter
@Setter
@ToString
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column
    private String mark;
    @Column
    private String model;
    @Column
    private double price;
}
