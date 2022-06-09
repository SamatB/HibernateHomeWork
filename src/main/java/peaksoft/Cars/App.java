package peaksoft.Cars;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.Students.Student;
import peaksoft.Teacher.Teachers;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class App
{
    public static void main( String[] args ) {
//        Cars cars = new Cars();
//        cars.setMark("MB");
//        cars.setModel("S-Class");
//        cars.setPrice(26475.7);
//        createCar(cars);
//        updateCars(1,"BMW", "7 series", 29999.9);
//        System.out.println(getAllCars());
//        System.out.println(getById(2));
        deleteById(1);

    }

    public static void createCar(Cars cars) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cars);
        session.getTransaction().commit();
        System.out.println(cars + " successfully created");
        session.close();
    }

    public static Cars getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Cars cars = session.get(Cars.class, id);
        session.getTransaction().commit();
        session.close();
        return cars;
    }

    public static void updateCars(int id, String mark, String model, double price) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Cars cars = session.get(Cars.class, id);
        cars.setMark(mark);
        cars.setModel(model);
        cars.setPrice(price);
        session.getTransaction().commit();
        System.out.println(cars + " successfully updated");
        session.close();
    }

    public static void deleteById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Cars cars = session.get(Cars.class, id);
        session.remove(cars);
        session.getTransaction().commit();
        System.out.println("car with id - " + id + " deleted");
        session.close();
    }

    public static List<Cars> getAllCars(){
        List cars;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        cars = session.createQuery("from Cars").getResultList();
        session.getTransaction().commit();
        session.close();
        return cars;
    }
}
