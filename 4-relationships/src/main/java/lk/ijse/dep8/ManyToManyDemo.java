package lk.ijse.dep8;

import lk.ijse.dep8.entity.Actor;
import lk.ijse.dep8.entity.Movie;
import lk.ijse.dep8.entity.Principal;
import lk.ijse.dep8.entity.School;
import lk.ijse.dep8.util.HibernateUtil;
import net.bytebuddy.asm.Advice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class ManyToManyDemo {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Actor dulanga = new Actor("A001", "Dulanga", Date.valueOf(LocalDate.now()));
            Actor sasitha = new Actor("A002", "Sasitha", Date.valueOf(LocalDate.now()));

            Movie ranja = new Movie("M001", "Ranja", Date.valueOf("2022-06-02"));
            Movie parlimentJokes = new Movie("M002", "Parliment Jokes", Date.valueOf("2022-06-02"));

            session.save(dulanga);
            session.save(sasitha);

            session.save(ranja);
            session.save(parlimentJokes);

            parlimentJokes.getActors().add(sasitha);
            parlimentJokes.getActors().add(dulanga);

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
