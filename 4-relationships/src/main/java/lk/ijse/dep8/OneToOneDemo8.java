package lk.ijse.dep8;

import lk.ijse.dep8.entity.Boy2;
import lk.ijse.dep8.entity.BoyGirl;
import lk.ijse.dep8.entity.BoyGirlPK;
import lk.ijse.dep8.entity.Girl2;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class OneToOneDemo8 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            BoyGirl boyGirl = session.get(BoyGirl.class, new BoyGirlPK("G001", "B001"));
            Boy2 sasitha = session.get(Boy2.class, "B002");

            session.remove(boyGirl);
            boyGirl.setPk(new BoyGirlPK(boyGirl.getGirl().getId(), sasitha.getId()));
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
