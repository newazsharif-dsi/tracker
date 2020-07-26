package com.activity.tracker.user.dao.impl;

import com.activity.tracker.model.SalesType;
import com.activity.tracker.user.dao.SalesTypeDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SalesTypeDaoImpl implements SalesTypeDao {

    @PersistenceContext
    EntityManager entityManager;

    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }


    @Override
    public List<SalesType> getAll() {
        return entityManager.createQuery("From SalesType").getResultList();
    }
}
