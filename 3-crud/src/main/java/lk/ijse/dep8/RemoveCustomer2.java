package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RemoveCustomer2 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

//            Customer kawwa = session.get(Customer.class, 2);
//            session.remove(kawwa);
//            System.out.println(session.contains(kawwa));
//            session.saveOrUpdate(kawwa);

//            Customer customer = new Customer(5, "Test", "Test");
//            session.update(customer);

            Customer test = session.get(Customer.class, 5);
            session.evict(test);
            session.delete(test);

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
