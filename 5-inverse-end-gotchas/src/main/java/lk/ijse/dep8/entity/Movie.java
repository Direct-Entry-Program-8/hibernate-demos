package lk.ijse.dep8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @JoinTable(name = "Actor_Movie",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Actor> actors = new HashSet<>();

    public Movie(String id, String name, Date releaseDate) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(releaseDate, movie.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseDate);
    }
}
