package com.activity.tracker.user.dao;

import com.activity.tracker.model.Employee;
import com.activity.tracker.model.Target;

import java.util.List;


public interface TargetDao {
    public List<Target> getAllTargets();

    public void save(Target user);

    public void saveOrUpdate(Target target);

    public Target findById(Integer id);

    public List<Target> getTargetsByEmployee(Employee employee);
}
