package org.example;

import jakarta.persistence.*;

@Entity()
@Table(name = "employees")
public class Employee {
    @Id  // every '@Entity' class must declare or inherit at least one '@Id' or '@EmbeddedId' property
//    @Column(name = "employee_id")
   private long id;
   private FullName ful_name ;
//    @Transient
    private int salary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FullName getFul_name() {
        return ful_name;
    }

    public void setFul_name(FullName ful_name) {
        this.ful_name = ful_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", ful_name=" + ful_name +
                ", salary=" + salary +
                '}';
    }
}
