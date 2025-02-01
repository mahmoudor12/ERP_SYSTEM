package com.example.ERP_SYSTEM.entities.Projekt;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name ="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Projekt-ID

    @Column(name = "project_name", nullable = false, length = 100)
    private String projectName; // Name des Projekts

    @Column(name = "description", nullable = true, length = 255)
    private String description; // Beschreibung des Projekts

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate; // Startdatum des Projekts

    @Column(name = "end_date", nullable = true)
    private LocalDate endDate; // Enddatum des Projekts

    @Column(name = "status", nullable = false, length = 50)
    private String status; // Status des Projekts (z.B. "In Progress", "Completed")

    // Beziehung zu den Tasks (Ein Projekt kann viele Tasks haben)
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Project(String projectName, String description, LocalDate startDate, LocalDate endDate, String status, List<Task> tasks) {
        this.projectName = projectName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.tasks = tasks;
    }

    public Project() {
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
