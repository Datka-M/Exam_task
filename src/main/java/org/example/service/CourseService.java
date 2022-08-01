package org.example.service;

import org.example.entity.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseService {

    void saveCourse(Course course);

    //sort by createAt
    Course getCourseById(Long id);

    List<Course> getAllCourses();

    void updateCourse(Long id,Course course);

    void deleteCourseById(Long id);

    Course getCourseByName(String courseName);
}
