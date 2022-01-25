package org.example.models;

import javax.validation.constraints.Size;
import java.util.Objects;

public class Student implements Comparable<Student>{


    @Size(min = 2, max = 30, message = "Surname must be between 2 and 30 characters")
    private String surname;

    public Student() {}

    public Student(String surname) {
        this.surname = surname;
    }

    public String getSurname(String surname) {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student students = (Student) o;
        return Objects.equals(surname, students.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname);
    }

    @Override
    public int compareTo(Student st){return this.surname.compareTo(st.surname);}
}

