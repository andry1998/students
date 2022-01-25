package org.example.controllers;

import org.example.dao.StudentDAO;
import org.example.models.Student;
import org.example.models.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentDAO studentsDAO;

    public StudentController(StudentDAO studentsDAO) {
        this.studentsDAO = studentsDAO;
    }

    @GetMapping()
    public Map<Student, List<Subject>> viewStudents(){
        return studentsDAO.showStudents();
    }

    //метод добавляет нового ученика и предметы с оценками(можно сразу добавлять несколько предметов)
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public String createStudent(@RequestBody Map<@Valid Student, List<@Valid Subject>> map) throws FileNotFoundException {
        studentsDAO.save(map);
        return "The HTTP Status will be OK (CODE 200)\n";
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public String updateStudent (@RequestBody  Map<@Valid Student, List<@Valid Subject>> map) throws FileNotFoundException {
        studentsDAO.update(map);
        return "The HTTP Status will be OK (CODE 200)\n";
    }
//
    @DeleteMapping("/delete")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public String deleteStudent(@RequestBody @Valid Student student) throws FileNotFoundException {
        studentsDAO.delete(student);
        return "The HTTP Status will be OK (CODE 200)\n";
    }
}
