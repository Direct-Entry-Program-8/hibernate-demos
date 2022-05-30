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
            //dulanga.setAddress("Jaffna");
            System.out.println("-------------");
            Object merge = session.merge(dulanga);
            System.out.println(merge == dulanga);

            //dulanga.setAddress("Panadura");
            //System.out.println(session.contains(dulanga));  // Yes
            //session.detach(dulanga);
            //Customer dulanga2 = session.get(Customer.class, 2);
            //System.out.println(session.contains(dulanga));  // No
            //System.out.println("------------------");
            //System.out.println(session.merge(dulanga) == dulanga2);
            //System.out.println(session.contains(dulanga));  // Yes

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
