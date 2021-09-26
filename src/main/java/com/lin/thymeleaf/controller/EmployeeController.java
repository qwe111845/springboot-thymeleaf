package com.lin.thymeleaf.controller;

import com.lin.thymeleaf.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {
        // create employees
        Employee employee1 = new Employee(1, "leslie", "Andrews", "leslie@gmail.com");
        Employee employee2 = new Employee(2, "Emma", "Bea", "Emma@gmail.com");
        Employee employee3 = new Employee(3, "Avani", "Gee", "Avani@gmail.com");

        // create the list
        theEmployees = new ArrayList<>();

        // add to the list
        theEmployees.add(employee1);
        theEmployees.add(employee2);
        theEmployees.add(employee3);

    }

    @GetMapping("/get")
    public String sayHello(Model theModel) {
        theModel.addAttribute("theEmployees", theEmployees);

        return "view/list-employee";
    }
}
