package com.MarkManagement.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query("select student from Student student where student.name like %:nameStudent% ")
    List<Student> findByName(@Param("nameStudent") String nameStudent);
    @Query("select student from Student student where ((student.chemistry + student.math + student.physics ) / 3) >= :AVG AND student.chemistry != 0 AND student.math != 0 AND student.physics != 0 ")
    List<Student> findStudentThan(@Param("AVG") Integer avg);
}
