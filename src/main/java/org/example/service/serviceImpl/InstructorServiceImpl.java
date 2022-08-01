package org.example.service.serviceImpl;

import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.repository.InstructorRepository;
import org.example.repository.impl.InstructorRepoImpl;
import org.example.service.InstructorService;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {

    private InstructorRepository repository = new InstructorRepoImpl();

    @Override
    public void saveInstructor(Instructor instructor) {
        repository.saveInstructor(instructor);
    }

    @Override
    public void updateInstructor(Long id,Instructor instructor) {
         repository.updateInstructor(id,instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return repository.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long courseId) {
        return repository.getInstructorByCourseId(courseId);
    }

    @Override
    public void deleteInstructorById(Long id) {
        repository.deleteInstructorById(id);
    }

    @Override
    public void assignInstructorToCourse(Long insId, Long courseId) {
         repository.assignInstructorToCourse(insId,courseId);
    }
}
