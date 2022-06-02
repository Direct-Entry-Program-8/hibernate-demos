package lk.ijse.dep8.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Actor_Movie")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActorMovie implements Serializable {
    @EmbeddedId
    private ActorMoviePK pk;
    @Column(name = "joined_date", nullable = false)
    private Date joinedDate;

    @JoinColumn(name = "actor_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    @Setter(AccessLevel.NONE)
    private Actor2 actor;

    @JoinColumn(name = "movie_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    @Setter(AccessLevel.NONE)
    private Movie2 movie;

    public ActorMovie(String actorId, String movieId, Date joinedDate) {
        this.pk = new ActorMoviePK(actorId, movieId);
        this.joinedDate = joinedDate;
    }

    public ActorMovie(ActorMoviePK pk, Date joinedDate) {
        this.pk = pk;
        this.joinedDate = joinedDate;
    }
}
