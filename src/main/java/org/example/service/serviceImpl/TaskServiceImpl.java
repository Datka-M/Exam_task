package org.example.service.serviceImpl;

import org.example.entity.Task;
import org.example.repository.TaskRepository;
import org.example.repository.impl.TaskRepoImpl;
import org.example.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepo = new TaskRepoImpl();


    @Override
    public void saveTask(Long lessonId,Task task) {
        taskRepo.saveTask(lessonId,task);
    }

    @Override
    public void updateTask(Long id, Task task) {
         taskRepo.updateTask(id,task);
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long lessonId) {
        return taskRepo.getAllTaskByLessonId(lessonId);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepo.deleteTaskById(id);
    }
}
