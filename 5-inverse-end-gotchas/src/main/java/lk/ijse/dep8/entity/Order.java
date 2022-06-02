package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`Order`")
public class Order implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private Date date;
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Customer customer;
}
