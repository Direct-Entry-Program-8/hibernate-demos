package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class QueryDemo4 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

//            Query<Customer> query = session.createQuery("");
//            Query<Customer> query1 = session.createQuery("", Customer.class);

            List<Customer> customers1 = session.
                    createQuery("FROM lk.ijse.dep8.entity.Customer c", Customer.class)
                    .list();
            customers1.forEach(System.out::println);

            List<String> customers2 = session.
                    createQuery("SELECT c.name FROM lk.ijse.dep8.entity.Customer c", String.class)
                    .list();
            customers2.forEach(System.out::println);

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
