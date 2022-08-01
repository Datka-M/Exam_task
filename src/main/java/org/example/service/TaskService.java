package org.example.service;

import org.example.entity.Task;

import java.util.List;

public interface TaskService {


    void saveTask(Long lessonId,Task task);

    void updateTask(Long id,Task task);

    List<Task> getAllTaskByLessonId(Long lessonId);

    void deleteTaskById(Long id);
}
