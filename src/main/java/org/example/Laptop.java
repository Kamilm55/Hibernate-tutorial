package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lid;
    private String name;

//    @OneToOne(targetEntity = Employee.class , cascade = CascadeType.ALL)
    @ManyToOne(targetEntity = Employee.class ) // Many Laptops => One Employee
    @JoinColumn(name = "employee_id" ,referencedColumnName = "id")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", name='" + name + '\'' +
                '}';
    }

    public long getLid() {
        return lid;
    }

    public void setLid(long lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
