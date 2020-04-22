package com.activity.tracker.user.service;

import com.activity.tracker.model.Employee;
import com.activity.tracker.user.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    public void save(Employee employee) {
        employeeDao.saveOrUpdate(employee);
    }

    public Employee findById(Integer id){
       return employeeDao.findById(id);
    }

    public Employee getEmployeeByEmployeeId(String employeeId) {
       return employeeDao.getEmployeeByEmployeeId(employeeId);
    }

}
