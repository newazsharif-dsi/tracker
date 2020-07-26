package com.activity.tracker.user.service;

import com.activity.tracker.model.SalesType;
import com.activity.tracker.user.dao.SalesTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesTypeService {

    @Autowired
    SalesTypeDao salesTypeDao;

    public List<SalesType> getAll() {
        return salesTypeDao.getAll();
    }


}
