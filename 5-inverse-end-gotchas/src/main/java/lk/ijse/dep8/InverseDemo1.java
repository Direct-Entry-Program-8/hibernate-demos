package lk.ijse.dep8;

import lk.ijse.dep8.entity.Employee;
import lk.ijse.dep8.entity.Spouse;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InverseDemo1 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Employee dula = new Employee("E001", "Dulanga");
            Employee kawwa = new Employee("E002", "Kawwa");
            Employee chamma = new Employee("E003", "Chamma");

            session.save(dula);
            session.save(kawwa);
            session.save(chamma);

            Spouse mashi = new Spouse("S001", "Mashi", dula);
            Spouse supuni = new Spouse("S002", "Supuni", kawwa);

            session.save(mashi);
            session.save(supuni);

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
