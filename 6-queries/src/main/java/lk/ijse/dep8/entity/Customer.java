package lk.ijse.dep8.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(name = "query1", query = "FROM Customer c")
@NamedQuery(name = "query2", query = "SELECT c FROM Customer c WHERE c.id=:customer_id")
@NamedNativeQuery(name = "query3", query = "SELECT * FROM Customer WHERE name LIKE CONCAT('%', ?1, '%')", resultClass = Customer.class)
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
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Order> orderList = new ArrayList<>();

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addOrder(Order order){
        order.setCustomer(this);
        orderList.add(order);
    }

    @PrePersist
    public void prePersist(){
        if (orderList != null){
            orderList.forEach(o -> o.setCustomer(this));
        }
    }
}
