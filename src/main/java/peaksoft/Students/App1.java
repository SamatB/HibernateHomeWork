package peaksoft.Students;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.util.HibernateUtil;
import java.util.List;

public class App1 {
    public static void main(String[] args) {
//        Student student = new Student();
//        student.setName("Muhammed");
//        student.setSurname("Almabekov");
//        student.setAge(27);
//        create(student);

//           updateStudent(1,"Maga", "Almazbekov", 25);

//        System.out.println(getById(1));
//        deleteById(1);
        System.out.println(getAllStudents());
    }

    public static void create(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

    public static Student getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public static void updateStudent(int id, String name, String surname, int age) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student students = session.get(Student.class, id);
        students.setName(name);
        students.setSurname(surname);
        students.setAge(age);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.remove(student);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Student> getAllStudents(){
        List students;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        students = session.createQuery("from Student").getResultList();
        session.getTransaction().commit();
        session.close();
        return students;
    }
}
