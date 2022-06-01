package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserPropertyPK implements Serializable {
    @Column(name = "user_nic")
    private String userNic;
    @Column(name = "property_id", unique = true)
    private String propertyId;
}
