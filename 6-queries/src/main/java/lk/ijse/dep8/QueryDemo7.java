package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryDemo7 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            session.getNamedQuery("query1").list().forEach(System.out::println);
            Customer c = session.createNamedQuery("query2", Customer.class).setParameter("customer_id", "C002")
                    .uniqueResult();
            System.out.println(c);

            session.createNamedQuery("query3", Customer.class).setParameter(1, "a").list().forEach(System.out::println);

            session.getNamedNativeQuery("query3")
                    .addEntity(Customer.class)
                    .setParameter(1, "a").list().
                    forEach(System.out::println);

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
