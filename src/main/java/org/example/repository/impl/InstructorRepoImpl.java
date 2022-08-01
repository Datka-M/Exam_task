package org.example.repository.impl;


import org.example.config.Config;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.repository.InstructorRepository;
import org.hibernate.HibernateException;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class InstructorRepoImpl implements InstructorRepository {
    @Override
    public void saveInstructor(Instructor instructor) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Save successfully");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Instructor instructor1 = entityManager.find(Instructor.class, id);
            instructor1.setFirstName(instructor.getFirstName());
            instructor1.setLastName(instructor.getLastName());
            instructor1.setEmail(instructor.getEmail());
            instructor1.setPhoneNumber(instructor.getPhoneNumber());
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("update");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Instructor getInstructorById(Long id) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return instructor;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    //kurska tieshelu instructorlordu chygaru
    @Override
    public List<Instructor> getInstructorByCourseId(Long courseId) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            List<Instructor>instructors = course.getInstructors();
            entityManager.getTransaction().commit();
            entityManager.close();
            return instructors;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    //if remove instructor, not remove course
    @Override
    public void deleteInstructorById(Long id) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, id);
            entityManager.remove(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Deleted");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void assignInstructorToCourse(Long insId, Long courseId) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, insId);
           Course course = entityManager.find(Course.class,courseId);
           instructor.addCourse(course);
           course.addInstructor(instructor);
           entityManager.persist(course);
           entityManager.persist(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();

        }catch (HibernateException e){
            e.printStackTrace();

        }
    }
}
