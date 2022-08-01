package org.example.repository;

import org.example.entity.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseRepository {

    void saveCourse(Course course);

    //sort by createAt
    Course getCourseById(Long id);

    List<Course> getAllCourses();

    void updateCourse(Long id,Course course);

    void deleteCourseById(Long id);

    Course getCourseByName(String courseName);




}
