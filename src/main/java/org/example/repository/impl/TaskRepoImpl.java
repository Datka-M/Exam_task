package org.example.repository.impl;


import org.example.config.Config;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.example.repository.TaskRepository;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class TaskRepoImpl implements TaskRepository {
    @Override
    public void saveTask(Long lessonId, Task task) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Lesson lesson = entityManager.find(Lesson.class, lessonId);
            lesson.setTasks(task);
            task.setLesson(lesson);
            entityManager.persist(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Save successfully");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTask(Long id, Task task) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Task task1 = entityManager.find(Task.class, id);
            task1.setDeadLine(task.getDeadLine());
            task1.setTask(task.getTask());
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("update");
        } catch (HibernateException e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long lessonId) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Lesson lesson = entityManager.find(Lesson.class, lessonId);
            List<Task> tasks = lesson.getTasks();
            entityManager.getTransaction().commit();
            entityManager.close();
            return tasks;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void deleteTaskById(Long id) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Task task = entityManager.find(Task.class, id);
            task.setLesson(null);
            entityManager.remove(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Deleted");
        } catch (HibernateException e) {
            System.out.println("IT'S EXCEPTION");
            e.printStackTrace();
        }
    }
}
