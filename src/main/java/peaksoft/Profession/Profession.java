package peaksoft.Profession;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "professions")
@Setter
@Getter
@ToString
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private double salary;
    @Column
    private String direction;

    public Profession() {
    }
}
