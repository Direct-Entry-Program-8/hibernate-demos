package lk.ijse.dep8;

import lk.ijse.dep8.entity.Actor2;
import lk.ijse.dep8.entity.ActorMovie;
import lk.ijse.dep8.entity.Movie2;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class ManyToManyDemo4 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

//            Actor2 dulanga = new Actor2("A001", "Dulanga", Date.valueOf(LocalDate.now()));
//            Actor2 kawwa = new Actor2("A002", "kawwa",Date.valueOf(LocalDate.now()));
//
//            Movie2 ranja = new Movie2("M001", "Ranja",Date.valueOf(LocalDate.now()) );
//            Movie2 ironman = new Movie2("M002", "ironman",Date.valueOf(LocalDate.now()));
//
//            session.update(dulanga);
//            session.update(kawwa);
//            session.update(ranja);
//            session.update(ironman);

            session.save(new ActorMovie("A001", "M001", Date.valueOf(LocalDate.now())));
            session.save(new ActorMovie("A001", "M002", Date.valueOf(LocalDate.now())));
            session.save(new ActorMovie("A002", "M001", Date.valueOf(LocalDate.now())));
            session.save(new ActorMovie("A002", "M002", Date.valueOf(LocalDate.now())));

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
