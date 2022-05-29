package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("{id}")
    public Department fetchDepartmentById( @PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("{id}")
    public String deleteDepartmentId(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentId(departmentId);
        return "Department deleted successfully!!";
    }

    @PutMapping("{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }
}
