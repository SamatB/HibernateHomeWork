package peaksoft.Teacher;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import peaksoft.Students.Student;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class App 
{
    public static void main( String[] args ) {
//    Teachers teacher = new Teachers();
//    teacher.setName("Samat");
//    teacher.setSurname("Beganov");
//    teacher.setPhoneNumber(999877215);
//    create(teacher);
//        updateTeacher(1, "Muhammed", "Almazbekov", 26);
//        System.out.println(getAllteachers());
//        System.out.println(getById(1));
        deleteById(1);
    }

    public static void create(Teachers teacher) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        System.out.println(teacher + " successfully created");
        session.close();
    }

    public static Teachers getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Teachers teacher = session.get(Teachers.class, id);
        session.getTransaction().commit();
        session.close();
        return teacher;
    }

    public static void updateTeacher(int id, String name, String surname, int phoneNumber) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Teachers teacher = session.get(Teachers.class, id);
        teacher.setName(name);
        teacher.setSurname(surname);
        teacher.setPhoneNumber(phoneNumber);
        session.getTransaction().commit();
        System.out.println(teacher + " successfully updated");
        session.close();
    }

    public static void deleteById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Teachers teacher = session.get(Teachers.class, id);
        session.remove(teacher);
        session.getTransaction().commit();
        System.out.println("teacher with id - " + id + " deleted");
        session.close();
    }

    public static List<Student> getAllteachers(){
        List teacher;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        teacher = session.createQuery("from Teachers").getResultList();
        session.getTransaction().commit();
        session.close();
        return teacher;
    }
}
