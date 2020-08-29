package com.activity.tracker.user.service;

import com.activity.tracker.model.ProductType;
import com.activity.tracker.user.dao.ProductTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {

    @Autowired
    ProductTypeDao productTypeDao;

    public List<ProductType> getAll() {
        return productTypeDao.getAll();
    }


}
