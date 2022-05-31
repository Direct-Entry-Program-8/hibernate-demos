package lk.ijse.dep8;

import lk.ijse.dep8.entity.Principal;
import lk.ijse.dep8.entity.School;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Principal principal = new Principal("P001", "Gihara", "gihara@ijse.lk");
            School school =
                    new School("S001", "IJSE", "Panadura", "011-1234567", principal);

            session.save(principal);
            session.save(school);

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
