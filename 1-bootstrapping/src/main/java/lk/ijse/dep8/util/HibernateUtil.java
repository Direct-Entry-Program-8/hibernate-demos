package lk.ijse.dep8.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static HibernateUtil instance;
    private final SessionFactory sessionFactory;

    private HibernateUtil() {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        sessionFactory = metadata.getSessionFactoryBuilder()
                .build();
    }

    public static HibernateUtil getInstance() {
        return (instance == null) ? (instance = new HibernateUtil()) : instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
