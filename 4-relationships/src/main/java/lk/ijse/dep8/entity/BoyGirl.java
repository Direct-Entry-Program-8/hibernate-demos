package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Boy_Girl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoyGirl {
    @EmbeddedId
    private BoyGirlPK pk;
    private Date anniversary;

    @JoinColumn(name = "boy_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne
    private Boy2 boy;

    @JoinColumn(name = "girl_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne
    private Girl2 girl;

    public BoyGirl(BoyGirlPK pk, Date anniversary) {
        this.pk = pk;
        this.anniversary = anniversary;
    }

    public BoyGirl(String girlId, String boyId, Date anniversary) {
        this.pk = new BoyGirlPK(girlId, boyId);
        this.anniversary = anniversary;
    }
}
