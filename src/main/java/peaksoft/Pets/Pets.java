package peaksoft.Pets;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pets")
@Getter
@Setter
@ToString
public class Pets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private double mass;

    public Pets() {
    }
}
