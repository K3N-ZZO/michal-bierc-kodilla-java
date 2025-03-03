package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John","Smith");
        Employee stephanieClarckson = new Employee("Stephanie","Clarckson");
        Employee lindaKovalsky = new Employee("Linda","Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies() .add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies() .add(dataMaesters);
        lindaKovalsky.getCompanies() .add(greyMatter);
        lindaKovalsky.getCompanies().add(dataMaesters);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaesterId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaesterId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
//        try{
//            companyDao.deleteById(softwareMachineId);
//            companyDao.deleteById(dataMaesterId);
//            companyDao.deleteById(greyMatterId);
//        } catch (Exception e){
//            //do nothing
//        }
    }

    @Test
    void testfindBythreeLetters(){
        //Given
        Company company1 = new Company("ABC TECH");
        Company company2 = new Company("DEF TECH");
        Company company3 = new Company("ABC MECH");

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        List<Company> companyList = companyDao.findByThreeLetters("ABC");

        //Then
        assertEquals(2, companyList.size());

        //Cleanup
        companyDao.delete(company1);
        companyDao.delete(company2);
        companyDao.delete(company3);


    }

}
