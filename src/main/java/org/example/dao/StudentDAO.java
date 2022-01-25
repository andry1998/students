package org.example.dao;

import org.example.models.Student;
import org.example.models.Subject;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;


@Component
public class StudentDAO {

    //private Map<Students, List<Subject>> map1 = new HashMap<>();
    private Map<Student, List<Subject>> map = new TreeMap<>();

    {
        Student s1 = new Student("Zaycev");
        List<Subject> sj1 = new ArrayList<>();
        sj1.add(new Subject("mathematics", new int[]{4,5}));
        sj1.add(new Subject("physics", new int[]{2,3,3,3}));
        sj1.add(new Subject("biology", new int[]{4,4,4,4,5,5,3,3,2,4,4,5}));
        sortSubject(sj1);
        map.put(s1, sj1);

        Student s2 = new Student("Sokolov");
        List<Subject> sj2 = new ArrayList<>();
        sj2.add(new Subject("mathematics", new int[]{4,5,3,3,3,3,3,4,5,5,5,5}));
        sj2.add(new Subject("physics", new int[]{5,2,2,2,2,3,3,2,3,4,3,3}));
        sj2.add(new Subject("biology", new int[]{4,4,4,4,4,5,5,4,5,4,5,3,4}));
        sortSubject(sj2);
        map.put(s2, sj2);

        Student s3 = new Student("ASobolev");
        List<Subject> sj3 = new ArrayList<>();
        sj3.add(new Subject("mathematics", new int[]{4,5,3,3,3,3,3,3,2,3,5}));
        sj3.add(new Subject("physics", new int[]{5,2,4,3,4,3,2,2,4}));
        sj3.add(new Subject("biology", new int[]{2,2,2,4,4,3,4,3,3,3,2,4}));
        sortSubject(sj3);
        map.put(s3, sj3);

        try {
            writeCSV(map, "StudentsInfo.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<Student, List<Subject>> showStudents(){
        return map;
    }


    public void save(Map<Student, List<Subject>> student) throws FileNotFoundException {
        List<Subject> subject = new ArrayList<>();
        Student studentInfo = new Student();

        for (Map.Entry<Student, List<Subject>> st : student.entrySet()) {
            studentInfo = st.getKey();
            for(int i = 0; i <  st.getValue().size(); i++){
                subject.add(st.getValue().get(i));
            }
        }
        map.put(studentInfo, subject);
        writeCSV(map, "StudentsInfo.csv");

    }

    public void update(Map<Student, List<Subject>> student) throws FileNotFoundException {
        List<Subject> subject = new ArrayList<>();
        Student studentInfo = new Student();
            for (Map.Entry<Student, List<Subject>> st : student.entrySet()){

                if (map.keySet().equals(st.getKey())){

                    for(int i = 0; i <  st.getValue().size(); i++){
                        subject.add(st.getValue().get(i));
                    }
                    map.put(studentInfo, subject);
                    writeCSV(map, "StudentsInfo.csv");
                }
                else{save(student);}
            }
    }

    public void delete(Student student) throws FileNotFoundException {
        map.remove(student);
        writeCSV(map, "StudentsInfo.csv");
    }


    public void writeCSV(Map<Student, List<Subject>> map, String fileName) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);
        for(Map.Entry<Student, List<Subject>> st : map.entrySet()){
            out.println(st.getKey());
            for (int i = 0; i < st.getValue().size(); i++) {
                out.println(st.getValue().get(i).getSubject() + "=" + Arrays.stream(st.getValue().get(i).getGrade()).average().orElse(0));
            }
        }
        out.close();
    }

    public void sortSubject(List<Subject> subject){
        subject.sort(Comparator.comparing(Subject::getSubject));
    }

}
