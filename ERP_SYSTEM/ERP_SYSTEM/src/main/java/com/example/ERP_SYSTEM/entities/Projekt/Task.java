package com.example.ERP_SYSTEM.entities.Projekt;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Task-ID

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project; // Verknüpfung zum Projekt (jede Aufgabe gehört zu einem Projekt)

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee; // Verknüpfung zu einem Mitarbeiter (jede Aufgabe wird von einem Mitarbeiter bearbeitet)

    @Column(name = "task_name", nullable = false, length = 100)
    private String taskName; // Name der Aufgabe

    @Column(name = "description", nullable = true, length = 255)
    private String description; // Beschreibung der Aufgabe

    @Column(name = "due_date", nullable = true)
    private LocalDate dueDate; // Fälligkeitsdatum der Aufgabe

    @Column(name = "status", nullable = false, length = 50)
    private String status; // Status der Aufgabe (z.B. "Open", "In Progress", "Completed")

    public Task(Project project, Employee employee, String taskName, String description, LocalDate dueDate, String status) {
        this.project = project;
        this.employee = employee;
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", project=" + project +
                ", employee=" + employee +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                '}';
    }
}
