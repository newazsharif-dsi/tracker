package com.activity.tracker.user.dao.impl;

import com.activity.tracker.model.Activity;
import com.activity.tracker.model.Employee;
import com.activity.tracker.user.dao.ActivityDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class ActivityDaoImpl implements ActivityDao {

    @PersistenceContext
    EntityManager entityManager;

    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }


    @Override
    public List<Activity> getAll() {
        return entityManager.createQuery("From Activity").getResultList();
    }

    @Override
    public List<Activity> getActivityByEmployee(Employee employee) {
        return entityManager.createQuery("From Activity a Where a.employee_id = :employee_id").setParameter("employee_id", employee.getId()).getResultList();
    }

    @Override
    public Activity findById(Integer id) {
        return entityManager.find(Activity.class, id);
    }


    @Override
    public void save(Employee employee) {
        getCurrentSession().save(employee);
    }


    @Override
    public void saveOrUpdate(Employee employee) {
        getCurrentSession().saveOrUpdate(employee);
        getCurrentSession().flush();
    }


    @Override
    public void update(Employee employee) {
        getCurrentSession().update(employee);
        getCurrentSession().flush();
    }

    @Override
    public void delete(Employee employee) {
        getCurrentSession().delete(employee);
    }

}
