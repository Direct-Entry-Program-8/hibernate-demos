package lk.ijse.dep8.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetails implements Serializable {
    private String name;
    private String address;
    @Column(name = "contact_number")
    private String contactNumber;
    private String email;
}
