package com.activity.tracker.user.dao;


import com.activity.tracker.model.Employee;

import java.util.List;


public interface EmployeeDao {
    public List<Employee> getAll();
    public Employee findById(Integer id);
    public Employee getEmployeeByEmployeeId(String employeeId);
    public void update(Employee employee);
    public void save(Employee employee);
    public void saveOrUpdate(Employee employee);
    public void delete(Employee employee);
}
