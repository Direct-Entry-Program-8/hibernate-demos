package lk.ijse.dep8;

import lk.ijse.dep8.entity.CustomEntity;
import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.entity.Order;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class QueryDemo5 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

//            session.
//                    createQuery("SELECT NEW lk.ijse.dep8.entity.CustomEntity(o.id, o.date, c.name) " +
//                            "FROM Order o INNER JOIN Customer c ON o.customer.id = c.id",
//                            CustomEntity.class).list().forEach(System.out::println);

//            session.
//                    createQuery("SELECT NEW lk.ijse.dep8.entity.CustomEntity(o.id, o.date, c.name) " +
//                            "FROM Order o INNER JOIN Customer c ON o.customer.id = c",
//                            CustomEntity.class).list().forEach(System.out::println);

//            session.
//                    createQuery("SELECT NEW lk.ijse.dep8.entity.CustomEntity(o.id, o.date, c.name) " +
//                                    "FROM Order o INNER JOIN Customer c ON o.customer = c",
//                            CustomEntity.class).list().forEach(System.out::println);

            session.
                    createQuery("SELECT NEW lk.ijse.dep8.entity.CustomEntity(o.id, o.date, c.name) " +
                                    "FROM Order o INNER JOIN o.customer c",
                            CustomEntity.class).list().forEach(System.out::println);

//            session.
//                    createQuery("SELECT NEW lk.ijse.dep8.entity.CustomEntity(o.id, o.date, c.name) " +
//                                    "FROM Order o INNER JOIN Customer c WITH o.customer.id = c.id",
//                            CustomEntity.class).list().forEach(System.out::println);

            session.createQuery("SELECT o.id, o.date, o.customer.name, c.contact FROM Order o LEFT OUTER JOIN Contact c ON o.customer = c.customer", Object[].class)
                            .list().forEach(row -> {
                                System.out.printf("%s, %s %s, %s \n", row[0], row[1], row[2], row[3]);
                    });



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
