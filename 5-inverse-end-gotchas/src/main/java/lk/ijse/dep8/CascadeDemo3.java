package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.entity.Order;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CascadeDemo3 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Customer dulanga = session.get(Customer.class, "C001");

            List<Order> orderList = new ArrayList<>();
            Customer bashi = new Customer("C002", "Bashi", orderList);
            orderList.add(new Order("OD001", Date.valueOf(LocalDate.now()), bashi ));
            orderList.add(new Order("OD003", Date.valueOf(LocalDate.now()), dulanga ));
            orderList.add(new Order("OD004", Date.valueOf(LocalDate.now()), bashi ));

            session.persist(bashi);

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
