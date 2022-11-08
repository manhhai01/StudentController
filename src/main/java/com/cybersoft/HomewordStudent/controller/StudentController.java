package com.cybersoft.HomewordStudent.controller;

import com.cybersoft.HomewordStudent.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    // Su dung @RequestParam
    @GetMapping("")
    public List<Student> addStudent1(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "age", required = true) int age) {
        students.add(new Student(name, age));
        return students;
    }

    // Su dung @PathVariable
    @GetMapping("/{name}/{age}")
    public List<Student> addStudent2(@PathVariable("name") String name, @PathVariable("age") int age) {
        students.add(new Student(name, age));
        return students;
    }

    // Su dung @RequestBody
    @PostMapping("")
    public List<Student> addStudent3(@RequestBody Student student) {
        Student studentAdd = new Student();
        studentAdd.setName(student.getName());
        studentAdd.setAge(student.getAge());

        students.add(studentAdd);
        return students;
    }
}
