package peaksoft.Groups;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class App
{
    public static void main( String[] args ) {
//        Groups groups = new Groups();
//        groups.setNumber(3);
//        groups.setName("Java NN");
//        create(groups);
//        updateGroups(2, "JavaRushHouse", 2);
//        System.out.println(getAllGroups());
//        System.out.println(getById(1));
        deleteById(2);

    }

    public static void create(Groups groups) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(groups);
        session.getTransaction().commit();
        System.out.println(groups + " successfully created");
        session.close();
    }

    public static Groups getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Groups groups = session.get(Groups.class, id);
        session.getTransaction().commit();
        session.close();
        return groups;
    }

    public static void updateGroups(int id, String name, int number) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Groups groups = session.get(Groups.class, id);
        groups.setNumber(number);
        groups.setName(name);
        session.getTransaction().commit();
        System.out.println(groups + " successfully updated");
        session.close();
    }

    public static void deleteById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Groups groups = session.get(Groups.class, id);
        session.remove(groups);
        session.getTransaction().commit();
        System.out.println("group with id - " + id + " deleted");
        session.close();
    }

    public static List<Groups> getAllGroups(){
        List groups;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        groups = session.createQuery("from Groups ").getResultList();
        session.getTransaction().commit();
        session.close();
        return groups;
    }
}
