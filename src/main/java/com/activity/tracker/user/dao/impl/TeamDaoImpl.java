package com.activity.tracker.user.dao.impl;

import com.activity.tracker.model.Team;
import com.activity.tracker.user.dao.TeamDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TeamDaoImpl implements TeamDao {

    @PersistenceContext
    EntityManager entityManager;

    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

    protected final Session getSession() {
        return this.getCurrentSession();
    }

    @Override
    public List<Team> getAllTeams() {
        return entityManager.createQuery("From Team").getResultList();
    }

}
