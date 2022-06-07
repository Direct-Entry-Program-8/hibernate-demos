package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountHolder implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Embedded
    private ContactDetails holderContactDetails;
    //@AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "office_name"))
            @AttributeOverride(name = "address", column = @Column(name = "office_address"))
            @AttributeOverride(name = "contactNumber", column = @Column(name = "office_contact_number"))
            @AttributeOverride(name = "email", column = @Column(name = "office_email"))
    //})
    @Embedded
    private ContactDetails officeContactDetails;

    @Lob // Blob, byte[], String (Clob)
    private Blob profilePicture;

    public AccountHolder(String name, String address, String contactNumber, String email,
                         String officeName, String officeAddress, String officeContactNumber, String officeEmail) {
        this.holderContactDetails = new ContactDetails(name, address, contactNumber, email);
        this.officeContactDetails = new ContactDetails(officeName, officeAddress, officeContactNumber, officeEmail);
    }
}
