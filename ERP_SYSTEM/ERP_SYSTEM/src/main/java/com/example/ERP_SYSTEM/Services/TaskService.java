package com.example.ERP_SYSTEM.Services;


import com.example.ERP_SYSTEM.Repo.TaskRepo;
import com.example.ERP_SYSTEM.entities.Projekt.Task;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

     @Autowired
     TaskRepo taskRepo;

     public void createTask(Task task){
         if (taskRepo.existsById(task.getId())){
             taskRepo.save(task);
         }else {
             throw  new EntityNotFoundException("Task with Id:" + task.getId() +"schon vorhandeln");
         }
     }
     public Task getTask(Integer id){
         return taskRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Task with Id:" + id +" nicht vorhandeln"));
     }
     public List<Task> getAll(){
         return taskRepo.findAll();
     }
     public void delete(Integer id){
         if(taskRepo.existsById(id)){
                taskRepo.deleteById(id);

         }else {
             throw new EntityNotFoundException("Task with Id: " + id + " nicht vorhandeln");
         }
     }

}
