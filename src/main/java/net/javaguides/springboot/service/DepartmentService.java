package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    public List<Department> fetchDepartmentList();
    public Department fetchDepartmentById(Long departmentId);
    public void deleteDepartmentId(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);
}
