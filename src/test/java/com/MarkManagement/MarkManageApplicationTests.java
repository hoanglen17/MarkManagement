package com.MarkManagement;
import com.MarkManagement.Student.Student;
import com.MarkManagement.Student.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
//@SpringBootTest
class MarkManageApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentTest() throws Exception{

//         given - precondition or setup
        Student student = new Student();
        student.setName("Student");
        student.setChemistry(4);
        student.setPhysics(5);
        student.setMath(6);

//        Student student = Student.builder()
//                        .name("Student")
//                                .chemistry(4)
//                                        .   math(5)
//                                                .physics(5).build();

        // When
        studentRepository.save(student);

        //Then
        Assertions.assertThat(student.getId()).isGreaterThan(0);

    }

    @Test
    public void getStudentTest(){
        Student student = studentRepository.findById(1).get();
        Assertions.assertThat(student.getId()).isEqualTo(1);
    }
}
