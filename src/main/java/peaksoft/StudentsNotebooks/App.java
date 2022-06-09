package peaksoft.StudentsNotebooks;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class App {
    public static void main(String[] args) {
//        Students_notebooks notebooks = new Students_notebooks();
//        notebooks.setModel("Aplle MacBook M1");
//        notebooks.setPrice(100000);
//        notebooks.setOwner("Bayaman");
//        create(notebooks);
//        updateNotebooks(1, "Acer Predator X1", 140000, "Muhammed");
//        System.out.println(getById(1));
        deleteById(2);
    }

    public static void create(Students_notebooks notebooks) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(notebooks);
        session.getTransaction().commit();
        System.out.println(notebooks + " successfully created");
        session.close();
    }

    public static Students_notebooks getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Students_notebooks notebooks = session.get(Students_notebooks.class, id);
        session.getTransaction().commit();
        session.close();
        return notebooks;
    }

    public static void updateNotebooks(int id, String model, double price, String owner) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Students_notebooks notebooks = session.get(Students_notebooks.class, id);
        notebooks.setModel(model);
        notebooks.setPrice(price);
        notebooks.setOwner(owner);
        session.getTransaction().commit();
        System.out.println(notebooks + " successfully updated");
        session.close();
    }

    public static void deleteById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Students_notebooks notebooks = session.get(Students_notebooks.class, id);
        session.remove(notebooks);
        session.getTransaction().commit();
        System.out.println("laptop with id - " + id + " deleted");
        session.close();
    }

    public static List<Students_notebooks> getAllLaptops() {
        List notebooks;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        notebooks = session.createQuery("from Students_notebooks ").getResultList();
        session.getTransaction().commit();
        session.close();
        return notebooks;
    }
}
