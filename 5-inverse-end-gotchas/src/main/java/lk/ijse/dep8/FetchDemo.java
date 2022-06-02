package lk.ijse.dep8;

import lk.ijse.dep8.entity.Actor;
import lk.ijse.dep8.entity.Employee;
import lk.ijse.dep8.entity.Movie;
import lk.ijse.dep8.entity.Spouse;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Iterator;

public class FetchDemo {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Movie m001 = session.get(Movie.class, "M001");
            System.out.println(m001.getName());
            Iterator<Actor> iterator = m001.getActors().iterator();
            //Actor actor = iterator.next();


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
