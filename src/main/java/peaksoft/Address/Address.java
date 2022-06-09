package peaksoft.Address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "adresses")
@Getter
@Setter
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int index;
    @Column
    private String name;
    @Column
    private String country;

    public Address() {

    }
}
