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
import java.util.Iterator;

public class CascadeDemo {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Customer chamma = new Customer("C002", "Chamma");
//            session.update(sasitha);
//            Customer sasitha = session.get(Customer.class, "C001");
            Order od003 = new Order("OD002", Date.valueOf(LocalDate.now()), chamma);

//            session.save(od001);
            Order od003Cloned = (Order) session.merge(od003);
            System.out.println(session.contains(od003));
            System.out.println(session.contains(chamma));
            System.out.println(session.contains(od003Cloned));
            System.out.println(session.contains(od003Cloned.getCustomer()));
            System.out.println((od003Cloned == od003));
            System.out.println((chamma == od003Cloned.getCustomer()));

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
