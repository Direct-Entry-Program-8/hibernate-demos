package lk.ijse.dep8.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JpaUtil {
    private final static EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("dep8");
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}
