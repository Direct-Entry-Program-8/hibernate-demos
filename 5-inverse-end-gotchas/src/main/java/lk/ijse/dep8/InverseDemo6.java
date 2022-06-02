package lk.ijse.dep8;

import lk.ijse.dep8.entity.Actor;
import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.entity.Movie;
import lk.ijse.dep8.entity.Order;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class InverseDemo6 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Actor gihara = new Actor("A001", "Gihara", Date.valueOf(LocalDate.now()));
            Actor nailn = new Actor("A002", "Nail", Date.valueOf(LocalDate.now()));
            Actor banda = new Actor("A003", "Banda", Date.valueOf(LocalDate.now()));
            Actor prabath = new Actor("A004", "Prabath", Date.valueOf(LocalDate.now()));

            session.save(gihara);
            session.save(nailn);
            session.save(banda);
            session.save(prabath);

            Movie ironMan = new Movie("M001", "Iron Man", Date.valueOf(LocalDate.now()));
            Movie liveFreeOrDieHard = new Movie("M002", "Live Free or Die Hard", Date.valueOf(LocalDate.now()));
            Movie theNet = new Movie("M003", "The Net", Date.valueOf(LocalDate.now()));

            session.save(ironMan);
            session.save(liveFreeOrDieHard);
            session.save(theNet);

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
