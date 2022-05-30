package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RefreshDemo2 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Customer kawwa = session.get(Customer.class, 2);
            session.detach(kawwa);
            System.out.println(session.contains(kawwa));        // false
            kawwa.setFullName("Kawwa+");
            Customer customer = session.get(Customer.class, 2);
            session.refresh(kawwa);
            System.out.println(session.contains(kawwa));        // true
            System.out.println(session.contains(customer));        // true

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
