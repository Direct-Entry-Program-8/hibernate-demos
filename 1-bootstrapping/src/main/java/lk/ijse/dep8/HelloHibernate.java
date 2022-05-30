package lk.ijse.dep8;

import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HelloHibernate {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println(session);
        session.close();
        sessionFactory.close();
    }
}
