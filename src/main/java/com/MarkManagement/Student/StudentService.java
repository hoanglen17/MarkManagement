package com.MarkManagement.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student findById(Integer id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    public List<Student> getStudent() {
            List<Student> students = new ArrayList<Student>();
            studentRepository.findAll().forEach(students1 -> students.add(students1));
        return students;
    }

    public void deleteById(Integer id) {
        Student student = studentRepository.findById(id).get();
        if(student != null){
            studentRepository.deleteById(id);
        }
    }

    public void updateStudent(Integer id, Student student) {
        Student studentFromDB = studentRepository.findById(id).get();
        if(studentFromDB != null){
            studentFromDB.setName(student.getName());
            studentRepository.save(studentFromDB);
        }
    }

    public List<Student> getStudentByName(String name) {
        return studentRepository.findByName(name);
    }
}

