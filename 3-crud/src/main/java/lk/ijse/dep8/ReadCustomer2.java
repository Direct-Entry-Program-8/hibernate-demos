package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReadCustomer2 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Customer customer = session.load(Customer.class, 10);
            System.out.println(customer.getFullName());
            Customer customer2 = session.getReference(Customer.class, 20);
            System.out.println(customer2.getId());

            session.getTransaction().commit();
        } catch (Throwable t) {
            t.printStackTrace();
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }finally{
            session.close();
            sf.close();
        }
    }
}
