package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeDaoTestSuite {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    void testFindByLastname(){
        Employee employee1 = new Employee("Jan","Kowalski");
        Employee employee2 = new Employee("Janina","Piotrowicz");
        Employee employee3 = new Employee("Tomasz","Kowalski");

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        List<Employee> kowalski = employeeDao.findByLastname("Kowalski");

        assertEquals(2, kowalski.size());

        employeeDao.delete(employee1);
        employeeDao.delete(employee2);
        employeeDao.delete(employee3);
    }
}
