package lk.ijse.dep8;

import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class QueryDemo2 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            /*NativeQuery nativeQuery = session.
                    createNativeQuery("UPDATE Customer SET name=? WHERE id=?");
            nativeQuery.setParameter(1, "Kasun");
            nativeQuery.setParameter(2, "C002");
            int affectedRows = nativeQuery.executeUpdate();
            System.out.println(affectedRows);*/

            int affectedRows = session.
                    createNativeQuery("UPDATE Customer SET name=?1 WHERE id=?10")
                    .setParameter(10, "Sunil")
                    .setParameter(1, "C002")
                    .executeUpdate();


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
