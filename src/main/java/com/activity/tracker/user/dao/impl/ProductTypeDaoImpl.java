/*
 * Copyright (c) 2020 UniInfoSys. All Rights Reserved.
 */

package com.activity.tracker.user.dao.impl;

import com.activity.tracker.model.ProductType;
import com.activity.tracker.user.dao.ProductTypeDao;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ProductTypeDaoImpl implements ProductTypeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTypeDaoImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }


    @Override
    public List<ProductType> getAll() {
        return entityManager.createQuery("From ProductType").getResultList();
    }
}
        