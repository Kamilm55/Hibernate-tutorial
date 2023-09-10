package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
// In very simple terms we can say JPA (Java persistence API) is like an interface and the hibernate is the implementation of the methods of the interface Like how insertion will be down is already defined with the help of hibernate
public class App 
{
    public static void main( String[] args )
    {
        FullName eFName = new FullName();
        eFName.setFirstName("Emp");
        eFName.setLastName("Lastname");
       Employee employee = new Employee();
       employee.setId(3);
       employee.setFul_name(eFName);
       employee.setSalary(1200);

//        System.out.println(employee);

        Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();


        session.save(employee);
        Employee getemployee = session.get(Employee.class,3);
        tx.commit();

        System.out.println(getemployee);
    }
}
