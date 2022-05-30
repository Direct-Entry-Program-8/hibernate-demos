package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReadCustomer3 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Customer loshi = session.get(Customer.class, 1);
            Customer loshi1 = session.get(Customer.class, 1);
            Customer loshi2 = session.get(Customer.class, 1);
            Customer loshi3 = session.get(Customer.class, 1);
            Customer loshi4 = session.get(Customer.class, 1);
            Customer loshi5 = session.get(Customer.class, 1);
            Customer loshi6 = session.get(Customer.class, 1);
            Customer loshi7 = session.get(Customer.class, 1);
            Customer loshi8 = session.get(Customer.class, 1);

            System.out.println(loshi == loshi2);
            System.out.println( loshi2 == loshi3);

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
