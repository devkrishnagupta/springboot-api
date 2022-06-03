package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.DepartmentNotFoundException;
import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping
    public Department saveDepartment(@Valid @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside the get departments");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("{id}")
    public Department fetchDepartmentById( @PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside the get departments by id");
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

    @GetMapping("name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
