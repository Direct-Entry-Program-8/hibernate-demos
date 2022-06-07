package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.entity.Order;
import lk.ijse.dep8.util.HibernateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Tuple;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class QueryDemo8 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            session.createQuery("FROM Order o", Order.class).list().forEach(System.out::println);
            session.createQuery("SELECT o.id FROM Order o", String.class).list().forEach(System.out::println);

//            session.createQuery("SELECT new lk.ijse.dep8.MyEntity(o.id, o.date) FROM Order o", MyEntity.class)
//                            .list().forEach(System.out::println);

            List<Map> list = session.
                    createQuery("SELECT new map(o.id as id, o.date as date) FROM Order o", Map.class)
                    .list();

            List<Tuple> list1 = session.createQuery("SELECT o.id as id, o.date as date FROM Order o",
                    Tuple.class).list();

            List<Object[]> list2 = session.createQuery("SELECT o.id as id, o.date as date FROM Order o",
                    Object[].class).list();

            Tuple tuple = list1.get(0);
            System.out.println(tuple.get("id"));
            System.out.println(tuple.get("date"));

//            System.out.println(map.get("id"));
//            System.out.println(map.get("date"));


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

