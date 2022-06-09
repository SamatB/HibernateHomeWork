package peaksoft.Students;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name", length = 55, unique = true)
    private String name;
    @Column(name = "surname", length = 50)
    private String surname;
    @Column
    private int age;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student: " +
                "id - " + id +
                ", name - " + name +
                ", surname - " + surname + '\'' +
                ", age - " + age;
    }
}
