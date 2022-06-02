package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Actor")
public class Actor2 implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(name = "dob", nullable = false)
    private Date dateOfBirth;
}
