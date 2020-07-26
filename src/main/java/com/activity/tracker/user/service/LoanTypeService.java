package com.activity.tracker.user.service;

import com.activity.tracker.model.LoanType;
import com.activity.tracker.user.dao.LoanTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanTypeService {

    @Autowired
    LoanTypeDao loanTypeDao;

    public List<LoanType> getAll() {
        return loanTypeDao.getAll();
    }


}
