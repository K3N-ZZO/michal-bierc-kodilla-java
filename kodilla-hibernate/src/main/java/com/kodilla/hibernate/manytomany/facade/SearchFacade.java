package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchFacade {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    public SearchFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompaniesByFragment(String fragment){
        return companyDao.findByFragment("%" + fragment + "%");
    }

    public List<Employee> findEmployeesByFragment(String fragment){
        return employeeDao.findByLastNameFragment("%" + fragment + "%");
    }
}
