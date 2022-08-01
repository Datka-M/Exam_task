package org.example.service.serviceImpl;

import org.example.entity.Course;
import org.example.repository.CourseRepository;
import org.example.repository.impl.CourseRepoImpl;
import org.example.service.CourseService;

import java.time.LocalDate;
import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseRepository repository = new CourseRepoImpl();

    @Override
    public void saveCourse(Course course) {
        repository.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return repository.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return repository.getAllCourses();
    }

    @Override
    public void updateCourse(Long id,Course course) {
         repository.updateCourse(id,course);
    }

    @Override
    public void deleteCourseById(Long id) {
        repository.deleteCourseById(id);
    }

    @Override
    public Course getCourseByName(String courseName) {
        return repository.getCourseByName(courseName);
    }
}
