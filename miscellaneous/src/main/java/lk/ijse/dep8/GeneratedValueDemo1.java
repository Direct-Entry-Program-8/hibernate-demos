package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.entity.Student;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class GeneratedValueDemo1 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try{
            session.beginTransaction();

            Customer loshi = new Customer("Loshi", "Matara");
            Serializable id = session.save(loshi);
            System.out.println(id);

            Student chamma1 = new Student("Chamma1", "011-1234567");
            session.persist(chamma1);

            Student chamma2 = new Student("Chamma2", "011-1234567");
            session.persist(chamma2);

            Student chamma3 = new Student("Chamma3", "011-1234567");
            session.persist(chamma3);

            session.getTransaction().commit();
        }catch (Throwable t){
            t.printStackTrace();
            if (session !=null && session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }finally {
            session.close();
            sf.close();
        }
    }

    public static void persist(){

    }
}
