package lk.ijse.dep8.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = "orderList")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    @Id
    private String id;
    private String name;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "customer")
    private List<Order> orderList = new ArrayList<>();

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addOrder(Order order){
        order.setCustomer(this);
        orderList.add(order);
    }


}
