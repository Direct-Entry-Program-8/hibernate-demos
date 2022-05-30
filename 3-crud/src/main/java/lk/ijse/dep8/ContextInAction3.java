package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextInAction3 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            // transient?? transient??
            Customer kawwa = new Customer(3, "Kawwa", "Walana");
            Customer clonedKawwa = (Customer) session.merge(kawwa);
            System.out.println(session.contains(kawwa));    // False
            System.out.println(session.contains(clonedKawwa));    // Yes
            System.out.println(kawwa == clonedKawwa);   // False
            System.out.println(kawwa);
            System.out.println(clonedKawwa);

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
