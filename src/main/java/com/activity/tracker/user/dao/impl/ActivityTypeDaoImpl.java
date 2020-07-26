package com.activity.tracker.user.dao.impl;

import com.activity.tracker.model.ActivityType;
import com.activity.tracker.user.dao.ActivityTypeDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ActivityTypeDaoImpl implements ActivityTypeDao {

    @PersistenceContext
    EntityManager entityManager;

    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }


    @Override
    public List<ActivityType> getAll() {
        return entityManager.createQuery("From ActivityType").getResultList();
    }
}
