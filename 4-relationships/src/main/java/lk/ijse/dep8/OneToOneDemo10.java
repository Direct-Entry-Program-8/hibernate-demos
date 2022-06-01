package lk.ijse.dep8;

import lk.ijse.dep8.entity.Lab;
import lk.ijse.dep8.entity.LabProjector;
import lk.ijse.dep8.entity.LabProjectorPK;
import lk.ijse.dep8.entity.Projector;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class OneToOneDemo10 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Lab cmjd = new Lab("L002", "CMJD");
            session.save(cmjd);
            LabProjector labProjector = session.get(LabProjector.class, new LabProjectorPK("L001", "P001"));

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
