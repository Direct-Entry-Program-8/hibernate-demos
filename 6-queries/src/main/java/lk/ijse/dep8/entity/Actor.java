package lk.ijse.dep8.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = "movies")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Actor implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(name = "dob", nullable = false)
    private Date dateOfBirth;

    @Setter(AccessLevel.NONE)
    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies = new ArrayList<>();

    public Actor(String id, String name, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public void addMovie(Movie movie) {
        movie.getActors().add(this);
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        movie.getActors().remove(this);
        movies.remove(movie);
    }
}
