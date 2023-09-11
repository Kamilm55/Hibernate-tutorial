package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

// In very simple terms we can say JPA (Java persistence API) is like an interface and the hibernate is the implementation of the methods of the interface Like how insertion will be down is already defined with the help of hibernate
public class App 
{
    public static void main( String[] args )
    {
        FullName eFName = new FullName();
        eFName.setFirstName("Emp");
        eFName.setLastName("Lastname");
//////////////////SET values/////////////////////
        Laptop empLaptop = new Laptop();
        Laptop empLaptop2 = new Laptop();
        List<Laptop> laptopList = new ArrayList<>();
        laptopList.add(empLaptop);
        laptopList.add(empLaptop2);
        empLaptop.setName("HP");
        empLaptop2.setName("Toshiba");
        Employee employee = new Employee();
       employee.setFul_name(eFName);
       employee.setSalary(1400);
       employee.setLaptop(laptopList);
        empLaptop.setEmployee(employee);
        empLaptop2.setEmployee(employee);
        /////////////////////Config////////////////
        Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
//////////////////CRUD OPERATIONS//////////
//        session.save(employee);

       Employee getemployee = session.get(Employee.class,4);
        System.out.println(getemployee);

        for(Laptop laptop : getemployee.getLaptop()) System.out.println(laptop);


//        session.delete(getLaptop);
        tx.commit();

    }
}
