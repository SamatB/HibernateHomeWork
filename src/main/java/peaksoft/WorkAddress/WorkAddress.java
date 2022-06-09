package peaksoft.WorkAddress;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "work_adress")
@Getter
@Setter
@ToString
public class WorkAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String company_name;
    @Column
    private String company_address;
    @Column
    private int index;

    public WorkAddress() {
    }
}
