package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.entity.Order;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class InverseDemo4 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Customer c001 = new Customer("C001", "Kasun");
            Customer c002 = new Customer("C002", "Nuwan");
            Customer c003 = new Customer("C003", "Ruwan");

            session.save(c001);
            session.save(c002);
            session.save(c003);

            session.save(new Order("OD001", Date.valueOf(LocalDate.now()), c001));
            session.save(new Order("OD002", Date.valueOf(LocalDate.now()), c001));
            session.save(new Order("OD003", Date.valueOf(LocalDate.now()), c002));
            session.save(new Order("OD004", Date.valueOf(LocalDate.now()), c002));

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
