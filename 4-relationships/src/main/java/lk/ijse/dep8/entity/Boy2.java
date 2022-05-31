package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Boy")
public class Boy2 {
    @Id
    private String id;
    private String name;
}
