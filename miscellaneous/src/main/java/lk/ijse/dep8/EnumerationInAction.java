package lk.ijse.dep8;

import lk.ijse.dep8.entity.Customer;
import lk.ijse.dep8.entity.Gender;
import lk.ijse.dep8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class EnumerationInAction {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try{
            session.beginTransaction();

            session.save(new Customer("Sasitha", "Kurangala", Gender.MALE));

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
