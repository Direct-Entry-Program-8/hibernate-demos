package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class ReadCustomer {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Customer customer = session.get(Customer.class, 1);
            System.out.println(customer);
            Customer customer2 = session.find(Customer.class, 2);
            System.out.println(customer2);

            session.getTransaction().commit();
        } catch (Throwable t) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }finally{
            session.close();
            sf.close();
        }
    }
}
