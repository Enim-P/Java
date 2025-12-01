package com.bing.service;

import com.bing.pojo.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    public List<Employee> getEmployees(){
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee(1,"张学友","男","香港"));
        emps.add(new Employee(2,"邓紫棋","女","香港"));
        return emps;
    }
}
