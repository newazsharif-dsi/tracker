package com.activity.tracker.user.service;

import com.activity.tracker.model.ActivityType;
import com.activity.tracker.user.dao.ActivityTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeService {

    @Autowired
    ActivityTypeDao activityTypeDao;

    public List<ActivityType> getAll() {
        return activityTypeDao.getAll();
    }


}
