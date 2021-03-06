package lk.ijse.dep8;

import lk.ijse.dep8.entity.Cart;
import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.entity.Order;
import lk.ijse.dep8.entity.User;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class OneToManyDemo3 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            User dula = new User("dulanga", "ADMIN", "Dulanga");
            User chamma = new User("chamma", "ADMIN", "Chamma");

            session.save(dula);
            session.save(chamma);

            session.save(new Cart("C1", Date.valueOf(LocalDate.now())));
            session.save(new Cart("C2", Date.valueOf(LocalDate.now()),dula));
            session.save(new Cart("C3", Date.valueOf(LocalDate.now()),dula));
            session.save(new Cart("C4", Date.valueOf(LocalDate.now()),chamma));

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
