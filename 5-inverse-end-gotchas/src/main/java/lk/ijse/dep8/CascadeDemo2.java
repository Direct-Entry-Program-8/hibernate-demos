package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.entity.Order;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class CascadeDemo2 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Order od002 = session.get(Order.class, "OD002");
            System.out.println(od002.getDate());
            System.out.println(od002.getCustomer());

            od002.setDate(Date.valueOf("2020-10-14"));
            od002.getCustomer().setName("Lahiru Something");

            session.refresh(od002);

            System.out.println(od002.getDate());
            System.out.println(od002.getCustomer());

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
