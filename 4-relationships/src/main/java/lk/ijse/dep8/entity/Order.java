package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "`Order`")
public class Order implements Serializable {
    @Id
    @Column(name = "order_id")
    private String orderId;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Customer customer;
}
