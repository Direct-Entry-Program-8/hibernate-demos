package lk.ijse.dep8.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserProperty implements Serializable {
    @EmbeddedId
    private UserPropertyPK pk;
    @Column(name = "purchase_date", nullable = false)
    private Date purchaseDate;

    @JoinColumn(name = "user_nic", referencedColumnName = "nic", insertable = false, updatable = false)
    @ManyToOne
    @Setter(AccessLevel.NONE)
    private User2 user;

    @JoinColumn(name = "property_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne
    @Setter(AccessLevel.NONE)
    private Property property;

    public UserProperty(UserPropertyPK pk, Date purchaseDate) {
        this.pk = pk;
        this.purchaseDate = purchaseDate;
    }

    public UserProperty(String userNic, String propertyId, Date purchaseDate) {
        this.pk = new UserPropertyPK(userNic, propertyId);
        this.purchaseDate = purchaseDate;
    }
}
