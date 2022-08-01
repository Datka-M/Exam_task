package org.example.repository.impl;

import org.example.config.Config;
import org.example.entity.Course;

import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.repository.CourseRepository;
import org.hibernate.HibernateException;


import javax.persistence.EntityManager;

import java.util.Collections;
import java.util.List;

public class CourseRepoImpl implements CourseRepository {
    @Override
    public void saveCourse(Course course) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Save successfully");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    // sort by createAt
    @Override
    public Course getCourseById(Long id) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return course;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Course> getAllCourses() {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            List<Course> courses = entityManager.createQuery("select c from Course c").getResultList();
            Collections.sort(courses);
            entityManager.getTransaction().commit();
            entityManager.close();
            return courses;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateCourse(Long id, Course course) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Course course1 = entityManager.find(Course.class, id);
            course1.setCourseName(course.getCourseName());
            course1.setDuration(course.getDuration());
            course1.setCreateAt(course.getCreateAt());
            course1.setImageLink(course.getImageLink());
            course1.setDescription(course.getDescription());
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("update");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    //not delete instructor,delete only lessons
    @Override
    public void deleteCourseById(Long id) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, id);
            for (Instructor i:course.getInstructors()) {
                i.setCourses(null);
            }
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Deleted");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course getCourseByName(String courseName) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Course course = entityManager
                    .createQuery("select c from Course c where c.courseName= :cName",Course.class)
                    .setParameter("cName",courseName).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return course;
        }catch (HibernateException e){
            e.printStackTrace();
            return null;
        }
    }
}
