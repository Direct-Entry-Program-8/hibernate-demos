package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class Spouse implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;

    @JoinColumn(name = "emp_id", referencedColumnName = "id", nullable = false)
    @OneToOne
    private Employee employee;
}
