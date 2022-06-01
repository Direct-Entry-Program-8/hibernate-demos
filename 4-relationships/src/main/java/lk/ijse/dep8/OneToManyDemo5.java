package lk.ijse.dep8;

import lk.ijse.dep8.entity.*;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class OneToManyDemo5 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            User2 kawwa = new User2("U001", "Kawwa");
            User2 thilina = new User2("U002", "Thilina");

            Property p001 = new Property("P001", "Panadura");

            session.save(kawwa);
            session.save(thilina);
            session.save(p001);

            UserProperty up01 = new UserProperty("U001", "P001", Date.valueOf(LocalDate.now()));
            session.save(up01);

//            UserProperty up02 = new UserProperty("U002", "P001", Date.valueOf(LocalDate.now()));
//            session.save(up02);

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
