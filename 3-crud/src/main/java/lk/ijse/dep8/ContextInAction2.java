package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextInAction2 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Customer dulanga = session.get(Customer.class, 2);
            dulanga.setAddress("Kadawatha");
            System.out.println(session.contains(dulanga));  // Yes
            session.detach(dulanga);
            System.out.println(session.contains(dulanga));  // No
            Customer dulanga2 = (Customer) session.merge(dulanga);
            System.out.println(session.contains(dulanga));  // false
            System.out.println(session.contains(dulanga2));  // true
            System.out.println(dulanga2 == dulanga);
            System.out.println(dulanga2);
            System.out.println(dulanga);

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
