package com.MarkManagement.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query("select student from Student student where student.name like %:nameStudent% ")
    List<Student> findByName(@Param("nameStudent") String nameStudent);
}
