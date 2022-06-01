package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart implements Serializable {
    @Id
    private String id;
    @Column(name = "created_date", nullable = false)
    private Date createdDate;
    @JoinTable(name = "User_Cart",
            joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "username"))
    @ManyToOne
    private User user;

    public Cart(String id, Date createdDate) {
        this.id = id;
        this.createdDate = createdDate;
    }
}
