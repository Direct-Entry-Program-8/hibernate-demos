package lk.ijse.dep8.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee extends PersonalInfo {

    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "employee")
    private Spouse spouse;

    public Employee(String id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
