package com.duyhung.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static StandardServiceRegistry registry = null;
    private static SessionFactory sessionFactory = null;
    public static SessionFactory getSessionFactory(){
        try {
            registry = new StandardServiceRegistryBuilder().configure().build();
            MetadataSources metadataSources = new MetadataSources(registry);
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }catch(Exception e){
            if(registry != null) StandardServiceRegistryBuilder.destroy(registry);
        }
        return sessionFactory;
    }

}
