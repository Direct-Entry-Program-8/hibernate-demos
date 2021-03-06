package lk.ijse.dep8;

import lk.ijse.dep8.entity.*;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneDemo3 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Teacher lahiru = new Teacher("T001", "Lahiru", "OOP");
            Teacher sasitha = new Teacher("T002", "Sasitha", "DBMS");
            Teacher kawwa = new Teacher("T003", "Kawwa", "NODE");

            session.save(lahiru);
            session.save(sasitha);
            session.save(kawwa);

            Schedule schedule1 = new Schedule("S001", "Something", lahiru);
            Schedule schedule2 = new Schedule("S002", "Something", sasitha);

            session.save(schedule1);
            session.save(schedule2);

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
