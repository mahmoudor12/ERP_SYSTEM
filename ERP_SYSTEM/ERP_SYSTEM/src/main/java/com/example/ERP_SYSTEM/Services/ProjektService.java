package com.example.ERP_SYSTEM.Services;


import com.example.ERP_SYSTEM.Repo.ProjektRepo;
import com.example.ERP_SYSTEM.entities.Projekt.Project;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjektService {

      @Autowired
      ProjektRepo projektRepo;

      public  void  createProjekt(Project project){

          if (projektRepo.existsById(project.getId())){
              projektRepo.save(project);

          } else{
              throw new EntityNotFoundException("Projekt with ID"+project.getId()+ "schon vorhandeln");
          }}

     public Project getProjekt(Integer id){
          return projektRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Projekt with ID"+ id + "schon vorhandeln"));
     }

     public List<Project> getAll(){
          return projektRepo.findAll();
      }
     public void update(Integer id, Project project){
            if (projektRepo.existsById(id)){
                Project project1 = projektRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Projekt with ID"+ id + "schon vorhandeln"));
                project1.setDescription(project1.getDescription());
                project1.setProjectName(project.getProjectName());
                project1.setEndDate(project.getEndDate());
                project1.setStatus(project.getStatus());
                project1.setTasks(project.getTasks());
                projektRepo.save(project1); }

     }
     public void delete(Integer id){
         if (projektRepo.existsById(id)){
                projektRepo.deleteById(id);
         }else
         {
             throw  new EntityNotFoundException("Projekt with ID"+ id + "schon vorhandeln");
         }

     }
}
