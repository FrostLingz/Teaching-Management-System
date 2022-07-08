package com.example.studentsmanagement.mapper;

import com.example.studentsmanagement.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * MyBatis
 */
@Mapper
@Component
public interface StudentMapper {

    // SELECT * FROM students where name LIKE %T%;
    @Select("SELECT * FROM student where name LIKE #{name}")
    List<Student> getStudentsContainStringInName(@Param("name")String name); //参数

    // SELECT * FROM student where university_class_id IN
    // (SELECT id FROM university_class where year = 2022 AND number = 1);
    @Select("SELECT * FROM student where university_class_id IN " +
             "(SELECT id FROM university_class where year = 2022 AND number = 1)")
    List<Student> getStudentInClass(@Param("year") int year, @Param("number") int number);


}
