package com.activity.tracker.user.dao.impl;

import com.activity.tracker.model.User;
import com.activity.tracker.user.dao.UserDao;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by newaz on 9/10/17.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }



    @Override
    public User getUserByUserName(String username) {
        List<User> userList = entityManager.createQuery("From User u where u.username = :username").setParameter("username", username).getResultList();
        return (userList != null && userList.size() > 0) ? userList.get(0): null;
    }

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("From User").getResultList();
    }

    @Override
    public void save(User user) {
        this.getCurrentSession().save(user);

    }

    @Override
    public void saveOrUpdate(User user) {
        this.getCurrentSession().saveOrUpdate(user);

    }

    @Override
    public void update(User user) {
        this.getCurrentSession().update(user);
    }

    @Override
    public void delete(User user) {
        this.getCurrentSession().delete(user);
    }
}
