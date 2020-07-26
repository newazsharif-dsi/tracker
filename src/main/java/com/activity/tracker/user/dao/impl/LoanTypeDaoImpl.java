package com.activity.tracker.user.dao.impl;

import com.activity.tracker.model.LoanType;
import com.activity.tracker.user.dao.LoanTypeDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class LoanTypeDaoImpl implements LoanTypeDao {

    @PersistenceContext
    EntityManager entityManager;

    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }


    @Override
    public List<LoanType> getAll() {
        return entityManager.createQuery("From LoanType").getResultList();
    }
}
