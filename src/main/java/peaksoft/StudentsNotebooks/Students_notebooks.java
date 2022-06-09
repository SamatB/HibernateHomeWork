package peaksoft.StudentsNotebooks;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students_laptops")
@Getter
@Setter
@ToString
public class Students_notebooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String model;
    @Column
    private double price;
    @Column
    private String owner;

    public Students_notebooks() {
    }
}
