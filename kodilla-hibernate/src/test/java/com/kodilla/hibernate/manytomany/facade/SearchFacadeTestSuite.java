package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SearchFacadeTestSuite {

    @Autowired
    private SearchFacade searchFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testFindCompaniesByFragment(){
        // given
        Company company = new Company("Software Machine");
        companyDao.save(company);

        // when
        List<Company> result = searchFacade.findCompaniesByFragment("ware");

        // then
        assertTrue(result.stream().anyMatch(c -> c.getName().equals("Software Machine")));
    }
    @Test
    void testFindEmployeesByFragment(){
        // given
        Employee employee = new Employee("Jan", "Kowalski");
        employeeDao.save(employee);

        // when
        List<Employee> result = searchFacade.findEmployeesByFragment("wals");

        // then
        assertTrue(result.stream().anyMatch(e -> e.getLastname().equals("Kowalski")));
    }
}
