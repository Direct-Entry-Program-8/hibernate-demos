package lk.ijse.dep8.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabProjector {
    @EmbeddedId
    private LabProjectorPK pk;
    @Column(name = "assign_date", nullable = false)
    private Date assignDate;
    @Column(nullable = false)
    private String assignee;

    @JoinColumn(name = "lab_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne
    @Setter(AccessLevel.NONE)
    private Lab lab;

    @JoinColumn(name = "projector_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne
    @Setter(AccessLevel.NONE)
    private Projector projector;

    public LabProjector(LabProjectorPK pk, Date assignDate, String assignee) {
        this.pk = pk;
        this.assignDate = assignDate;
        this.assignee = assignee;
    }

    public LabProjector(String labId, String projectorId, Date assignDate, String assignee) {
        this.pk = new LabProjectorPK(labId, projectorId);
        this.assignDate = assignDate;
        this.assignee = assignee;
    }
}
