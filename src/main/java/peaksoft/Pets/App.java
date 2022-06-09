package peaksoft.Pets;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class App
{
    public static void main( String[] args ) {
//      Pets pets = new Pets();
//      pets.setName("Dog");
//      pets.setAge(1);
//      pets.setMass(11.5);
//      create(pets);
//        updatePets(1,"Cat", 1, 3.4);
//        System.out.println(getAllPets());
//        System.out.println(getById(1));
        deleteById(2);
    }

    public static void create(Pets pets) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(pets);
        session.getTransaction().commit();
        System.out.println(pets + " successfully created");
        session.close();
    }

    public static Pets getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Pets pets = session.get(Pets.class, id);
        session.getTransaction().commit();
        session.close();
        return pets;
    }

    public static void updatePets(int id, String name, int age, double mass) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Pets pets = session.get(Pets.class, id);
        pets.setName(name);
        pets.setAge(age);
        pets.setMass(mass);
        session.getTransaction().commit();
        System.out.println(pets + " successfully updated");
        session.close();
    }

    public static void deleteById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Pets pets = session.get(Pets.class, id);
        session.remove(pets);
        session.getTransaction().commit();
        System.out.println("pet with id - " + id + " deleted");
        session.close();
    }

    public static List<Pets> getAllPets(){
        List pets;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        pets = session.createQuery("from Pets").getResultList();
        session.getTransaction().commit();
        session.close();
        return pets;
    }
}
