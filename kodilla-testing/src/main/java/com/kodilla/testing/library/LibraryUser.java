package com.kodilla.testing.library;

import java.util.*;

public class LibraryUser {
    private String name;
    private String lastname;
    private String peselId;

    public LibraryUser(String name, String lastname, String peselId) {
        this.name = name;
        this.lastname = lastname;
        this.peselId = peselId;
    }

    public String getName() {
        return name;
    }

    public String getPeselId() {
        return peselId;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryUser that = (LibraryUser) o;
        return name.equals(that.name) && lastname.equals(that.lastname) && peselId.equals(that.peselId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, peselId);
    }
}
