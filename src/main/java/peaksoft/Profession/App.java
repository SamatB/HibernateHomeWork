package peaksoft.Profession;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class App
{
    public static void main( String[] args ) {
//        Profession profession = new Profession();
//        profession.setName("Building Engineer");
//        profession.setDirection("Construction");
//        profession.setSalary(150000);
//        create(profession);
//        updateTeacher(1, "taxi Driver", 70000, "passengers transportation - taxi");
//        System.out.println(getById(2));
        deleteById(1);
    }

    public static void create(Profession profession) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(profession);
        session.getTransaction().commit();
        System.out.println(profession + " successfully created");
        session.close();
    }

    public static Profession getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Profession profession = session.get(Profession.class, id);
        session.getTransaction().commit();
        session.close();
        return profession;
    }

    public static void updateTeacher(int id, String name, double salary, String direct) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Profession profession = session.get(Profession.class, id);
        profession.setName(name);
        profession.setSalary(salary);
        profession.setDirection(direct);
        session.getTransaction().commit();
        System.out.println(profession + " successfully updated");
        session.close();
    }

    public static void deleteById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Profession profession = session.get(Profession.class, id);
        session.remove(profession);
        session.getTransaction().commit();
        System.out.println("profession with id - " + id + " deleted");
        session.close();
    }

    public static List<Profession> getAllProfessions(){
        List prof;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        prof = session.createQuery("from Profession ").getResultList();
        session.getTransaction().commit();
        session.close();
        return prof;
    }
}
