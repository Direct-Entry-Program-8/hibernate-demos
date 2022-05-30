package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateCustomer {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Customer loshi1 = new Customer(1, "Loshi", "Panadura Walana");
            loshi1.setAddress("Matara");
            boolean isInContext = session.contains(loshi1);
            System.out.println(isInContext);

            Customer loshi2 = session.get(Customer.class, 1);
            isInContext = session.contains(loshi2);
            System.out.println(isInContext);
            loshi2.setAddress("Wadduwa");

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
