package lk.ijse.dep8;

import lk.ijse.dep8.entity.Actor;
import lk.ijse.dep8.entity.Movie;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class InverseDemo8 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Movie ironMan = session.get(Movie.class, "M001");
//            System.out.println(ironMan.getActors());
            Actor gihara = session.get(Actor.class, "A001");

            System.out.println(gihara.getMovies());
            //System.out.println(gihara.getMovies().size());
            //ironMan.getActors().remove(gihara);
//            gihara.addMovie(ironMan);
            //gihara.removeMovie(ironMan);
//            gihara.getMovies().add(ironMan);
            //gihara.getMovies().add(new Movie("M004", "Oyai Mamai", Date.valueOf(LocalDate.now())));

//            Actor admin = new Actor("A005", "Admin", Date.valueOf(LocalDate.now()));
//            session.save(admin);
//            ironMan.getActors().add(admin);

            session.getTransaction().commit();
        } catch (Throwable t) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            t.printStackTrace();
        } finally {
            session.close();
            sf.close();
        }
    }
}
