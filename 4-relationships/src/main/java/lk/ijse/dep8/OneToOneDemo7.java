package lk.ijse.dep8;

import lk.ijse.dep8.entity.Boy2;
import lk.ijse.dep8.entity.BoyGirl;
import lk.ijse.dep8.entity.Girl2;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class OneToOneDemo7 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Boy2 dulanga = session.get(Boy2.class, "B001");
            Girl2 kasuni = session.get(Girl2.class, "G001");

            BoyGirl boyGirl = new BoyGirl(kasuni.getId(), dulanga.getId(), Date.valueOf(LocalDate.now()));
            session.save(boyGirl);

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
