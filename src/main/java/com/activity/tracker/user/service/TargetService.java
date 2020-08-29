package com.activity.tracker.user.service;

import com.activity.tracker.model.Employee;
import com.activity.tracker.model.Target;
import com.activity.tracker.user.dao.TargetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetService {

    @Autowired
    TargetDao targetDao;

    public List<Target> getAllTargets() {
        return targetDao.getAllTargets();
    }

    public void save(Target target) {
        targetDao.saveOrUpdate(target);
    }

    public Target findById(Integer id) {
        return targetDao.findById(id);
    }

    public List<Target> getTargetsByEmployee(Employee employee) {
        return targetDao.getTargetsByEmployee(employee);
    }

}