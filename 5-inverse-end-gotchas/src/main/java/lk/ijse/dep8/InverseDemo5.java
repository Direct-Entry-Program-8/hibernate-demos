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

public class InverseDemo5 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Customer c001 = session.get(Customer.class, "C001");
            Order od003 = session.get(Order.class, "OD003");

//            c001.getOrderList().add(od003);
            c001.addOrder(od003);
            System.out.println(c001.getOrderList());

//            Customer c003 = session.get(Customer.class, "C003");
//            Order od001 = session.get(Order.class, "OD001");
//
//            List<Order> orderList = new ArrayList<>();
//            orderList.add(od001);

            //c003.setOrderList(orderList);

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
