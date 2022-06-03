package lk.ijse.dep8;

import lk.ijse.dep8.entity.CustomEntity;
import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryDemo6 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            session.createQuery("FROM Customer c", Customer.class).list().forEach(System.out::println);
            System.out.println(session.createQuery("SELECT c FROM Customer c WHERE c.id=?1", Customer.class)
                            .setParameter(1, "C001").uniqueResult());
            session.createNativeQuery("SELECT * FROM Customer WHERE name LIKE CONCAT('%', ?1, '%')", Customer.class)
                            .setParameter(1, "a").list().forEach(System.out::println);

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
