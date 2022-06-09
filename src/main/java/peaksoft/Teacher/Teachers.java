package peaksoft.Teacher;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@ToString
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(name = "phone_number")
    private long phoneNumber;

    public Teachers() {
    }
}
