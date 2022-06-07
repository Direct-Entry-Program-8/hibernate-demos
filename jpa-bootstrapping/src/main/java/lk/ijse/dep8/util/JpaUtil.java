package lk.ijse.dep8.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Properties;

public abstract class JpaUtil {
    private final static EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
        Properties prop = new Properties();
        try {
            prop.load(JpaUtil.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Persistence.createEntityManagerFactory("dep8",prop);
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}
