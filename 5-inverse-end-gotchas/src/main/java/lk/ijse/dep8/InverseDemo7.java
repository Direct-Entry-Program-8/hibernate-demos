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

public class InverseDemo7 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Movie ironMan = session.get(Movie.class, "M001");
            Movie dieHard = session.get(Movie.class, "M002");
            Movie net = session.get(Movie.class, "M003");

            Actor gihara = session.get(Actor.class, "A001");
            Actor nalin = session.get(Actor.class, "A002");
            Actor banda = session.get(Actor.class, "A003");
            Actor prabath = session.get(Actor.class, "A004");

            ironMan.getActors().add(gihara);
            ironMan.getActors().add(prabath);
            ironMan.getActors().add(nalin);

            Set<Actor> actors = new HashSet<>();
            actors.add(gihara);
            dieHard.setActors(actors);

            Set<Actor> actorsForNetMovie = new HashSet<>();
            actorsForNetMovie.add(banda);
            actorsForNetMovie.add(gihara);
            net.setActors(actorsForNetMovie);

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
