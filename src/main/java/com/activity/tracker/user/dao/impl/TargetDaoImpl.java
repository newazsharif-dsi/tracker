package com.activity.tracker.user.dao.impl;

import com.activity.tracker.model.Employee;
import com.activity.tracker.model.Target;
import com.activity.tracker.user.dao.TargetDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class TargetDaoImpl implements TargetDao {

    @PersistenceContext
    EntityManager entityManager;

    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public List<Target> getAllTargets() {
        return entityManager.createQuery("From Target").getResultList();
    }

    @Override
    public void save(Target target) {
        this.getCurrentSession().save(target);

    }

    @Override
    public void saveOrUpdate(Target target) {
        this.getCurrentSession().saveOrUpdate(target);

    }

    @Override
    public Target findById(Integer id) {
        return entityManager.find(Target.class, id);
    }


    @Override
    public List<Target> getTargetsByEmployee(Employee employee) {
        return entityManager.createQuery("From Target t Where t.employee_id = :employee_id").setParameter("employee_id", employee.getId()).getResultList();
    }


}
