package com.example.ERP_SYSTEM.Services;


import com.example.ERP_SYSTEM.entities.Projekt.Employee;
import com.example.ERP_SYSTEM.Repo.EmployeeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    // Konstruktor
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // Mitarbeiter erstellen
    public void createEmployee(Employee employee) {
        if (!employeeRepo.existsById(employee.getId())) {
            employeeRepo.save(employee);
        } else {
            throw new EntityNotFoundException("Employee mit ID " + employee.getId() + " existiert bereits.");
        }
    }

    // Einen Mitarbeiter anhand der ID abrufen
    public Employee getEmployee(Integer id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee mit ID " + id + " nicht gefunden."));
    }

    // Alle Mitarbeiter abrufen
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    // Einen Mitarbeiter anhand der ID löschen
    public void deleteEmployee(Integer id) {
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
        } else {
            throw new EntityNotFoundException("Employee mit ID " + id + " existiert nicht.");
        }
    }

    // Mitarbeiter aktualisieren
    public void updateEmployee(Integer id, Employee employee) {
        if (employeeRepo.existsById(id)) {
            Employee existingEmployee = employeeRepo.findById(id).orElse(null);
            if (existingEmployee != null) {
                existingEmployee.setFirstname(employee.getFirstname());
                existingEmployee.setLastname(employee.getLastname());
                existingEmployee.setEmail(employee.getEmail());
                existingEmployee.setPhoneNumber(employee.getPhoneNumber());
                existingEmployee.setAddress(employee.getAddress());
                existingEmployee.setPurchaseOrders(employee.getPurchaseOrders());
                existingEmployee.setTasks(employee.getTasks());
                employeeRepo.save(existingEmployee);
            }
        } else {
            throw new EntityNotFoundException("Employee mit ID " + id + " existiert nicht.");
        }
    }
}
