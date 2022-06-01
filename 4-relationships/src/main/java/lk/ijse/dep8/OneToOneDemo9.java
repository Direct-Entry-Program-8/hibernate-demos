package lk.ijse.dep8;

import lk.ijse.dep8.entity.*;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;

public class OneToOneDemo9 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Lab depLab = new Lab("L001", "DEP");
            Projector epson = new Projector("P001", "EPSON");

            session.save(depLab);
            session.save(epson);

            LabProjector kasun = new LabProjector(depLab.getId(), epson.getId(), Date.valueOf(LocalDate.now()), "Kasun");
            session.save(kasun);

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
