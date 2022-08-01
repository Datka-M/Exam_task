package org.example.service;

import org.example.entity.Course;
import org.example.entity.Instructor;

import java.util.List;

public interface InstructorService {

    void saveInstructor(Instructor instructor);

    void updateInstructor(Long id,Instructor instructor);

    Instructor getInstructorById(Long id);

    List<Instructor> getInstructorByCourseId(Long courseId);

    //if remove instructor, not remove course
    void deleteInstructorById(Long id);
     void assignInstructorToCourse(Long insId, Long courseId);
}
