package lk.ijse.dep8;

import lk.ijse.dep8.entity.ActorMovie;
import lk.ijse.dep8.entity.ActorMoviePK;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class ManyToManyDemo5 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            ActorMovie actorMovie = session.get(ActorMovie.class, new ActorMoviePK("A002", "M002"));
            session.delete(actorMovie);

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
