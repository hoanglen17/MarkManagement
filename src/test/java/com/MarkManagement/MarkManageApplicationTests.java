package com.MarkManagement;
import com.MarkManagement.Student.Student;
import com.MarkManagement.Student.StudentRepository;
import com.MarkManagement.Student.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MarkManageApplicationTests {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;


    @Test
    public void saveStudentTest(){
//         given - precondition or setup
        Student mockStudent = new Student();
        mockStudent.setId(1L);
        mockStudent.setName("Student");
        mockStudent.setChemistry(4);
        mockStudent.setPhysics(5);
        mockStudent.setMath(6);

        // 2. define behavior of Repository
        Student studentResult = new Student();
        when(studentRepository.save(mockStudent)).thenReturn(mockStudent);

        // 3. call service method
        studentService.save(mockStudent);
        assertThat(mockStudent.getId()).isGreaterThan(0);

        // 4. ensure repository is called
        verify(studentRepository).save(mockStudent);
    }
//    @Test
//    public void deleteStudentTest(){
////         given - precondition or setup
//        Student mockStudent = new Student();
//        mockStudent.setId(1L);
//        mockStudent.setName("Student");
//        mockStudent.setChemistry(4);
//        mockStudent.setPhysics(5);
//        mockStudent.setMath(6);
//
//        // 2. define behavior of Repository
//        Student studentResult = new Student();
//        when(studentRepository.delete(mockStudent)).thenReturn(Student.class);
//
//        // 3. call service method
//        studentService.save(mockStudent);
//        assertThat(mockStudent.getId()).isGreaterThan(0);
//
//        // 4. ensure repository is called
//        verify(studentRepository).save(mockStudent);
//    }
    @Test
    public void getStudentTest() {
        // 1. create mock data
        List<Student> mockStudents = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            mockStudents.add(new Student());
        }

        // 2. define behavior of Repository
        when(studentRepository.findAll()).thenReturn(mockStudents);

        // 3. call service method
        List<Student> actualBooks = studentService.getStudent();

        // 4. assert the result
        assertThat(actualBooks.size()).isEqualTo(mockStudents.size());

        // 4.1 ensure repository is called
        verify(studentRepository).findAll();
    }

    @Test
    public void getStudentThanTest(){
        // 1. create mock data
        Student student = new Student();
        student.setName("Student");
        student.setChemistry(4);
        student.setPhysics(5);
        student.setMath(6);

        List<Student> mockStudents = new ArrayList<>();
        mockStudents.add(student);


        // 2. define behavior of Repository
        when(studentRepository.findAll()).thenReturn(mockStudents);

        // 3. call service method
        List<Student> actualBooks = studentService.getStudent();

        // 4. assert the result
        assertThat(actualBooks.size()).isEqualTo(mockStudents.size());

        // 4.1 ensure repository is called
        verify(studentRepository).findAll();
    }

    public void getStudentThanTest_HaveMarkEqualZero(){
        // 1. create mock data
        Student student = new Student();
        student.setName("Student");
        student.setChemistry(0);
        student.setPhysics(5);
        student.setMath(6);

        List<Student> mockBooks = new ArrayList<>();
        mockBooks.add(student);


        // 2. define behavior of Repository
        when(studentRepository.findAll()).thenReturn(mockBooks);

        // 3. call service method
        List<Student> actualBooks = studentService.getStudent();

        // 4. assert the result
        assertThat(actualBooks.size()).isNotEqualTo(mockBooks.size());

        // 4.1 ensure repository is called
        verify(studentRepository).findAll();
    }
}
