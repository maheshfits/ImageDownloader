/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package du.se.imagedownloader.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import du.se.imagedownloader.dto.City;
import du.se.imagedownloader.dto.Instagram;
import du.se.imagedownloader.dto.Comment;
import du.se.imagedownloader.dto.Country;
import du.se.imagedownloader.dto.Location;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author 
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure()
                    .addAnnotatedClass(Country.class)
                    .addAnnotatedClass(City.class)
                    .addAnnotatedClass(Location.class)
                    .addAnnotatedClass(Instagram.class)
                    .addAnnotatedClass(Comment.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
