package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    private String id;
    @Column(nullable = false)
    private String details;
    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false, unique = true)
    private Teacher teacher;
}
