package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data @AllArgsConstructor @NoArgsConstructor
public class BoyGirlPK implements Serializable {
    @Column(name = "girl_id")
    private String girlId;
    @Column(name = "boy_id")
    private String boyId;
}
