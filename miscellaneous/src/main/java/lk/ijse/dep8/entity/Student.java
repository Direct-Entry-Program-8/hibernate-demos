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
    @SequenceGenerator(name = "student_seq1", sequenceName = "student_seq", allocationSize = 1)
    @SequenceGenerator(name = "student_seq2")
    @SequenceGenerator(name = "student_seq3")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq1")
    private int id;
    private String name;
    @Column(name = "contact_number")
    private String contactNumber;

    public Student(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }
}
