package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Boy {
    @Id
    private String id;
    private String name;

    @JoinTable(name = "Girl_Boy",
            joinColumns = @JoinColumn(name = "boy_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "girl_id", referencedColumnName = "id", unique = true))
    @OneToOne
    private Girl gir;

    public Boy(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
