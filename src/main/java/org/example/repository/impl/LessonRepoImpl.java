package org.example.repository.impl;

import org.example.config.Config;
import org.example.entity.Course;

import org.example.entity.Lesson;
import org.example.repository.LessonRepository;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.util.List;

public class LessonRepoImpl implements LessonRepository {

    //when save lesson,save lesson to course
    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            lesson.setCourse(course);
            entityManager.persist(lesson);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Save successfully");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Lesson lesson1 = entityManager.find(Lesson.class, id);
            lesson1.setName(lesson.getName());
            lesson1.setVideoLink(lesson.getVideoLink());
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("update");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Lesson getLessonById(Long id) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Lesson lesson = entityManager.find(Lesson.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return lesson;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    //kurska tieshelu sabaktardy chygaruu
    @Override
    public void getLessonsByCourseId(Long id) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, id);
            List<Lesson> lessons = course.getLessons();
            System.out.println(lessons);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (HibernateException e) {
            e.printStackTrace();

        }
    }
}
