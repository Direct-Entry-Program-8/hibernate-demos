package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    //    @TableGenerator(name = "id_generator", table = "dep_sequence",
//            pkColumnName = "table_name",
//            valueColumnName = "value",
//            pkColumnValue = "Customer", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private PersonalDetail personalDetail;

    public Customer(String name, String address, Gender gender) {
        personalDetail = new PersonalDetail(name, address, gender);
    }
}
