package com.activity.tracker.user.dao;


import com.activity.tracker.model.Activity;
import com.activity.tracker.model.Employee;

import java.util.List;


public interface ActivityDao {
    public List<Activity> getAll();
    public List<Activity> getActivityByEmployee(Employee employee);
    public Activity findById(Integer id);
    public void update(Activity activity);
    public void save(Activity activity);
    public void saveOrUpdate(Activity activity);
    public void delete(Activity activity);

}
