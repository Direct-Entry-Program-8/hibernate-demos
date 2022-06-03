package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Spouse extends PersonalInfo {
    @JoinColumn(name = "emp_id", referencedColumnName = "id", nullable = false, unique = true)
    @OneToOne
    private Employee employee;

    public Spouse(String id, String name, Employee employee) {
        super(id, name);
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Spouse{" +
                super.toString() +
                "employee=" + employee +
                '}';
    }
}
