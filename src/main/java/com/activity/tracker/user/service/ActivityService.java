package com.activity.tracker.user.service;


import com.activity.tracker.model.Activity;
import com.activity.tracker.model.Employee;
import com.activity.tracker.user.dao.ActivityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    ActivityDao activityDao;

    public List<Activity> getActivityByEmployee(Employee employee) {
        return activityDao.getActivityByEmployee(employee);
    }

    public List<Activity> getAll() {
        return activityDao.getAll();
    }

    public void save(Activity activity) {
        activityDao.saveOrUpdate(activity);
    }


    public Activity findById(Integer id) {
        return activityDao.findById(id);
    }
}
