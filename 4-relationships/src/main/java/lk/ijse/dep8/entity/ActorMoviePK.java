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
public class ActorMoviePK implements Serializable {
    @Column(name = "actor_id")
    private String actorId;
    @Column(name = "movie_id")
    private String movieId;
}
