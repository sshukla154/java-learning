package sshukla.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author 'Seemant Shukla' on '26/09/2022'
 */
public class HibernateCrudOperation {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        session.save(myObject);
    }

}
