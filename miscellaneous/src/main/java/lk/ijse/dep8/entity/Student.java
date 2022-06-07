package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student implements Serializable {

    @TableGenerator(name = "id_generator", table = "dep_sequence",
            pkColumnName = "table_name",
            valueColumnName = "value",
            pkColumnValue = "Student", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
    @Id
    private int id;
    private String name;
    @Column(name = "contact_number")
    private String contactNumber;

    public Student(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }
}
