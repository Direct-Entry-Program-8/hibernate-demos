package lk.ijse.dep8;

import lk.ijse.dep8.entity.Boy;
import lk.ijse.dep8.entity.Girl;
import lk.ijse.dep8.entity.Schedule;
import lk.ijse.dep8.entity.Teacher;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo4 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Girl kasuni = new Girl("G001", "Kasuni");
            Girl ruwani = new Girl("G002", "Ruwani");
            Girl supuni = new Girl("G003", "Supuni");
            Girl nuwani = new Girl("G004", "Nuwani");

            session.save(kasuni);
            session.save(ruwani);
            session.save(supuni);
            session.save(nuwani);

            Boy dulanga = new Boy("B001", "Dulanga");
            Boy sasitha = new Boy("B002", "Sasitha");
            Boy thilina = new Boy("B003", "Thilina");
            Boy kawwa = new Boy("B004", "Kawwa");

            session.save(dulanga);
            session.save(sasitha);
            session.save(thilina);
            session.save(kawwa);

            sasitha.setGir(nuwani);
            kawwa.setGir(kasuni);
            thilina.setGir(supuni);

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
