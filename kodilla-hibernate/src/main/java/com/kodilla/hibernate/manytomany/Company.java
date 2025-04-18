package com.kodilla.hibernate.manytomany;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "Company.findByFragment",
        query = "FROM Company WHERE name LIKE :ARG"
)


@NamedNativeQuery(
        name = "Company.findByThreeLetters",
        query = "SELECT * FROM COMPANIES WHERE substring(COMPANY_NAME,1,3) = :prefix",
        resultClass = Company.class
)
@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<Employee>();

    public Company() {
    }
    public Company(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID",unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
