package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Employee implements Serializable {
    @Id
    private String id;

    @AttributeOverride(name = "name", column = @Column(name = "emp_name"))
    @AttributeOverride(name = "address", column = @Column(name = "emp_address"))
    @Embedded
    private PersonalDetail personalDetail;

    public Employee(String id, String name, String address, Gender gender) {
        this.id = id;
        this.personalDetail = new PersonalDetail(name, address, gender);
    }
}
