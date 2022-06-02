package lk.ijse.dep8;

import lk.ijse.dep8.entity.Employee;
import lk.ijse.dep8.entity.Spouse;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InverseDemo3 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Spouse mashi = session.get(Spouse.class, "S001");
//            System.out.println(mashi.getEmployee().getName());

//            Employee chamma = session.get(Employee.class, "E003");
//            mashi.setEmployee(chamma);

            Employee dula = session.get(Employee.class, "E001");
//            dula.setSpouse(mashi);

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
