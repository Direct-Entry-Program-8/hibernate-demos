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
public class LabProjectorPK implements Serializable {
    @Column(name = "lab_id")
    private String labId;
    @Column(name = "projector_id")
    private String projectorId;
}
