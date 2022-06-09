package peaksoft.Groups;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "groups")
@Getter
@Setter
@ToString
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int number;
    @Column
    private  String name;

    public Groups() {

    }
}
