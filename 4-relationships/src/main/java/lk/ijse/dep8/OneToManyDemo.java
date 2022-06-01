package lk.ijse.dep8;

import lk.ijse.dep8.entity.*;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class OneToManyDemo {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Customer dulanga = new Customer("C001", "Dulanga", "Matara");
            session.save(dulanga);

            session.save(new Order("OD001", new Date(), dulanga));
            session.save(new Order("OD002", new Date(), dulanga));
            session.save(new Order("OD003", new Date(), dulanga));
            session.save(new Order("OD004", new Date(), dulanga));

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
