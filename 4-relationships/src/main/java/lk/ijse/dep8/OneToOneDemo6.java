package lk.ijse.dep8;

import lk.ijse.dep8.entity.Boy;
import lk.ijse.dep8.entity.Boy2;
import lk.ijse.dep8.entity.Girl;
import lk.ijse.dep8.entity.Girl2;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo6 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Girl2 kasuni = new Girl2("G001", "Kasuni");
            Girl2 ruwani = new Girl2("G002", "Ruwani");
            Girl2 supuni = new Girl2("G003", "Supuni");
            Girl2 nuwani = new Girl2("G004", "Nuwani");

            session.save(kasuni);
            session.save(ruwani);
            session.save(supuni);
            session.save(nuwani);

            Boy2 dulanga = new Boy2("B001", "Dulanga");
            Boy2 sasitha = new Boy2("B002", "Sasitha");
            Boy2 thilina = new Boy2("B003", "Thilina");
            Boy2 kawwa = new Boy2("B004", "Kawwa");

            session.save(dulanga);
            session.save(sasitha);
            session.save(thilina);
            session.save(kawwa);

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
