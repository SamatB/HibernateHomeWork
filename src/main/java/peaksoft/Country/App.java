package peaksoft.Country;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.Students.Student;
import peaksoft.Teacher.Teachers;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class App
{
    public static void main( String[] args ) {
//        Country country = new Country();
//        country.setName("Russia");
//        country.setCapital("Moscow");
//        country.setArea(17125191.3);
//        country.setPopulation(145550300);
//        createCountry(country);
//        updateCountry(2, "Kyrgyzstan", "Bishkek", 199951.2, 6523529);
//        System.out.println(getAllCountries());
//        System.out.println(getById(1));
        deleteById(2);
    }

    public static void createCountry(Country country) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(country);
        session.getTransaction().commit();
        System.out.println(country + " successfully created");
        session.close();
    }

    public static Country getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Country country = session.get(Country.class, id);
        session.getTransaction().commit();
        session.close();
        return country;
    }

    public static void updateCountry(int id, String name, String capital, double area, int population) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Country country = session.get(Country.class, id);
        country.setName(name);
        country.setCapital(capital);
        country.setArea(area);
        country.setPopulation(population);
        session.getTransaction().commit();
        System.out.println(country + " successfully updated");
        session.close();
    }

    public static void deleteById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Country country = session.get(Country.class, id);
        session.remove(country);
        session.getTransaction().commit();
        System.out.println("country with id - " + id + " deleted");
        session.close();
    }

    public static List<Country> getAllCountries(){
        List country;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        country = session.createQuery("from Country").getResultList();
        session.getTransaction().commit();
        session.close();
        return country;
    }
}
