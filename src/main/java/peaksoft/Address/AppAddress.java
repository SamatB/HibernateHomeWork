package peaksoft.Address;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.Students.Student;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class AppAddress
{
    public static void main( String[] args ) {
//        Address address = new Address();
//        address.setIndex(113422);
//        address.setName("Bishkek");
//        address.setCountry("Kyrgyzstan");
//        createAddress(address);
//        updateAddress(1,122465,"New-York", "USA");
//        System.out.println(getById(1));
        deleteById(1);
    }
    public static void createAddress(Address address) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        System.out.println(address + " successfully created");
        session.close();
    }

    public static Address getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Address adress = session.get(Address.class, id);
        session.getTransaction().commit();
        session.close();
        return adress;
    }

    public static void updateAddress(int id, int index, String name, String country) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Address address = session.get(Address.class, id);
        address.setIndex(index);
        address.setName(name);
        address.setCountry(country);
        session.getTransaction().commit();
        System.out.println(address + " successfully updated");
        session.close();
    }

    public static void deleteById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Address adress = session.get(Address.class, id);
        session.remove(adress);
        session.getTransaction().commit();
        System.out.println("address with id - " + id + " deleted");
        session.close();
    }

    public static List<Student> getAllAddresses(){
        List address;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        address = session.createQuery("from Address").getResultList();
        session.getTransaction().commit();
        session.close();
        return address;
    }
}
