package com.MarkManagement.controller;

import com.MarkManagement.Student.Student;
import com.MarkManagement.Student.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public List<Student> saveStudent(){
        Student student = new Student();
        student.setName("Student");
        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 0) + 1) + 0;
        student.setMath(randomNum);
        randomNum = rand.nextInt((10 - 0) + 1) + 0;
        student.setPhysics(randomNum);
        randomNum = rand.nextInt((10 - 0) + 1) + 0;
        student.setChemistry(randomNum);
        studentService.save(student);

        return studentService.getStudent();
    }
    @GetMapping("/getStudent")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }
    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public List<Student>  deleteStudentById(@PathVariable("id") Long id){
        studentService.deleteById(id);
        return studentService.getStudent();
    }
    @PutMapping("/updateStudent/{id}")
    public List<Student>  updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        studentService.updateStudent(id,student);
        return studentService.getStudent();
    }
    @GetMapping("/getStudentByName")
    public List<Student> getStudentByName(@RequestBody Student student){
        String nameStudent = student.getName();
        return studentService.getStudentByName(nameStudent);
    }
    @GetMapping("/getStudentThan/{AVG}")
    public List<Student> getStudentThan(@PathVariable("AVG") Integer AVG){
        return studentService.getStudentThan(AVG);
    }
}
