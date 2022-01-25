package org.example.models;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Objects;
import java.util.OptionalDouble;

@Validated
public class Subject {

    @Size(min = 2, max = 30, message = "Subject name must be between 2 and 30 characters")
    private String subject;

    private int[] grade;

    public Subject(String subject, int[] grade) {
        this.subject = subject;
        this.grade = grade;
        //System.out.println(Arrays.stream(grade).average());
    }

//    public OptionalDouble SubjectAverage(String subject, int[] grade) {
//        this.subject = subject;
//        this.grade = grade;
//        return Arrays.stream(grade).average();
//    }

    public Subject() {}

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int[] getGrade() {
        return grade;
    }

    public void setGrade(int[] grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject1 = (Subject) o;
        return Objects.equals(subject, subject1.subject) && Arrays.equals(grade, subject1.grade);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(subject);
        result = 31 * result + Arrays.hashCode(grade);
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject='" + subject + '\'' +
                ", grade=" + Arrays.toString(grade) +
                '}';
    }
}
