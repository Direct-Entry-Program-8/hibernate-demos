package lk.ijse.dep8;

import lk.ijse.dep8.entity.Actor;
import lk.ijse.dep8.entity.Actor2;
import lk.ijse.dep8.entity.Movie;
import lk.ijse.dep8.entity.Movie2;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class ManyToManyDemo3 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Actor2 dulanga = new Actor2("A001", "Dulanga", Date.valueOf(LocalDate.now()));
            Actor2 kawwa = new Actor2("A002", "kawwa",Date.valueOf(LocalDate.now()));
            Actor2 lahiru = new Actor2("A003", "lahiru",Date.valueOf(LocalDate.now()));
            Actor2 bashi = new Actor2("A004", "bashi",Date.valueOf(LocalDate.now()));

            session.save(dulanga);
            session.save(kawwa);
            session.save(lahiru);
            session.save(bashi);

            Movie2 ranja = new Movie2("M001", "Ranja",Date.valueOf(LocalDate.now()) );
            Movie2 ironman = new Movie2("M002", "ironman",Date.valueOf(LocalDate.now()));
            Movie2 parlimentJokes = new Movie2("M003", "parlimentJokes",Date.valueOf(LocalDate.now()));
            Movie2 marryMe = new Movie2("M004", "marryMe",Date.valueOf(LocalDate.now()));

            session.save(ranja);
            session.save(ironman);
            session.save(parlimentJokes);
            session.save(marryMe);

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
