package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextInAction4 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

//            Customer kawwa = session.get(Customer.class, 3);
//            session.detach(kawwa);
//            kawwa.setAddress("Panadura");
//            session.saveOrUpdate(kawwa);    // SELECT -> (DETACH) INSERT, UPDATE ✅ ?
            session.get(Customer.class, 2);

            Customer customer = new Customer(2, "Kawwa", "Kadeawtha");
            session.saveOrUpdate(customer); // SELECT -> (DETACH) INSERT, UPDATE ✅
            System.out.println(session.contains(customer));

            session.getTransaction().commit();
        } catch (Throwable t) {
            t.printStackTrace();
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }finally{
            session.close();
            sf.close();
        }
    }
}
