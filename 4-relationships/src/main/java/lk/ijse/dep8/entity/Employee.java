package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    private String id;
    private String name;
    private String department;

    @JoinTable(name = "Employee_Vehicle",
            joinColumns =
            @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "vehicle_id", referencedColumnName = "registration_number", unique = true))
    @OneToOne
    private Vehicle vehicle;

    public Employee(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}
