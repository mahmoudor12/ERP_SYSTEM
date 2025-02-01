package com.example.ERP_SYSTEM.entities.Stocks;


import com.example.ERP_SYSTEM.entities.Projekt.Employee;
import com.example.ERP_SYSTEM.entities.Projekt.Project;
import jakarta.persistence.*;


import java.time.LocalDate;


@Entity
@Table
public class stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "project_id", columnDefinition = "id")
    private Project project;

    @ManyToOne
    @JoinColumn(name="employee_id", columnDefinition = "id")
    private Employee employee;

    @Column(name = "taskname" , nullable = false)
    private String taskName;

    @Column(name = "description" ,nullable = false)
    private String description ;
    @Column(name = "due_date", nullable = true)
    private LocalDate dueDate; // Fälligkeitsdatum der Aufgabe

    @Column(name = "status", nullable = false, length = 50)
    private String status; // Status der Aufgabe (z.B. "Open", "In Progress", "Completed")

    public stock(Project project, Employee employee, String taskName, String description, LocalDate dueDate, String status) {
        this.project = project;
        this.employee = employee;
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
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

    public stock() {
    }

    @Override
    public String toString() {
        return "stock{" +
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
