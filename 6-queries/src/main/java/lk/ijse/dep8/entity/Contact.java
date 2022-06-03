package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact {
    @Id
    private String id;
    @Column(name = "contact_number", nullable = false, unique = true)
    private String contact;
    @JoinTable(name = "Customer_Contact",
            joinColumns = @JoinColumn(name = "contact_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
    @ManyToOne
    private Customer customer;
}
