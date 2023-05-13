package controller;


import model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.DepartmentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department {} added", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        LOGGER.info("Department find all");
        return departmentRepository.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        LOGGER.info("Department find id {}", id);
        return departmentRepository.findDepartmentById(id);
    }


}
