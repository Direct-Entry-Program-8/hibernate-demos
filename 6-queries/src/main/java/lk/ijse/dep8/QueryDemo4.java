package lk.ijse.dep8;

import lk.ijse.dep8.entity.CustomEntity;
import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.entity.Order;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class QueryDemo4 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

//            Query<Customer> query = session.createQuery("");
//            Query<Customer> query1 = session.createQuery("", Customer.class);

//            List<Customer> customers1 = session.
//                    createQuery("FROM lk.ijse.dep8.entity.Customer c", Customer.class)
//                    .list();
//            customers1.forEach(System.out::println);
//
//            List<String> customers2 = session.
//                    createQuery("SELECT c.name FROM lk.ijse.dep8.entity.Customer c", String.class)
//                    .list();
//            customers2.forEach(System.out::println);

            session.createQuery("FROM Order o", Order.class).list().forEach(System.out::println);

            Order od001 = session.createQuery("FROM Order o WHERE o.id=?1", Order.class)
                    .setParameter(1, "OD001").uniqueResult();
            System.out.println(od001);

            session.createQuery("SELECT DISTINCT o.customer FROM Order o", Customer.class).list().forEach(System.out::println);

            session.createQuery("SELECT DISTINCT o.customer.name FROM Order o", String.class).list().forEach(System.out::println);

//            List<Object[]> list = session.
//                    createQuery("SELECT o.id, o.date, o.customer.name FROM Order o").list();
//            list.forEach(row -> {
//                System.out.println(row[0]);
//                System.out.println(row[1]);
//                System.out.println(row[2]);
//                System.out.println("-----------------");
//            });

            List<CustomEntity> list = session.
createQuery("SELECT NEW lk.ijse.dep8.entity.CustomEntity(o.id, o.date, o.customer.name) FROM Order o",
        CustomEntity.class).list();
            list.forEach(System.out::println);
//            new CustomEntity(id ,date, customerName)

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
