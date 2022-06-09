package peaksoft.WorkAddress;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class App {
    public static void main(String[] args) {
//     WorkAddress address = new WorkAddress();
//     address.setCompany_name("Nestle");
//     address.setCompany_address("avenue Nestlé 55, 1800 Vevey, Switzerland");
//     address.setIndex(12578);
//     create(address);
//        updateWorkAddress(3, "ZOA", "LLC. Address. 5301 Wisconsin Ave NW, Suite 570 Washington", 123114);
//        System.out.println(getAllWorkAddresses());
//        System.out.println(getById(1));
        deleteById(2);
    }

    public static void create(WorkAddress address) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        session.close();
    }

    public static WorkAddress getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        WorkAddress address = session.get(WorkAddress.class, id);
        session.getTransaction().commit();
        session.close();
        return address;
    }

    public static void updateWorkAddress(int id, String company_name, String company_address, int index) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        WorkAddress address = session.get(WorkAddress.class, id);
        address.setCompany_name(company_name);
        address.setCompany_address(company_address);
        address.setIndex(index);
        session.getTransaction().commit();
        System.out.println(address + " updated");
        session.close();
    }

    public static void deleteById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        WorkAddress address = session.get(WorkAddress.class, id);
        session.remove(address);
        session.getTransaction().commit();
        System.out.println(address + " deleted");
        session.close();
    }

    public static List<WorkAddress> getAllWorkAddresses(){
        List address;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        address = session.createQuery("from WorkAddress").getResultList();
        session.getTransaction().commit();
        session.close();
        return address;
    }
}
