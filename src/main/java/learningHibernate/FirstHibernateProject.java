package main.java.learningHibernate;

import main.java.learningHibernate.model.Address;
import main.java.learningHibernate.model.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;


public class FirstHibernateProject {

    public static void main(String[] args) {

        UserDetails userDetails = new UserDetails();
        Address address = new Address();
        //we are using GeneratedValue in model class so we no need to set primary key id it will be take care by hibernate
//        userDetails.setUserId(1);
        userDetails.setName("First User");
        address.setStreet("SarkarThopu");
        address.setCity("Nellore");
        address.setState("AndhraPradesh");
        address.setPincode("524366");
        userDetails.setAddress(address);
        userDetails.setJoinedDate(new Date());
        userDetails.setDescription("Engineer");

        UserDetails userDetails1 = new UserDetails();
        Address address1 = new Address();
        userDetails1.setName("Second User");
        address1.setStreet("Thiparajuvari");
        address1.setCity("Nellore");
        address1.setState("AndhraPradesh");
        address1.setPincode("524001");
        userDetails1.setAddress(address1);
        userDetails1.setJoinedDate(new Date());
        userDetails1.setDescription("Mechanic");

        SessionFactory sessionFactory = new Configuration().configure("main/resources/META-INF/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.save(userDetails1);
        session.getTransaction().commit();
        session.close();

        //Fetch data from database
        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails = session.get(UserDetails.class, 1);
        System.out.println("User description retrieved is " +userDetails.getUserId());
    }
}
