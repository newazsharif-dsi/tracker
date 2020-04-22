package com.activity.tracker.user.dao.impl;

import com.activity.tracker.model.Employee;
import com.activity.tracker.user.dao.EmployeeDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    EntityManager entityManager;

    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }


    @Override
    public List<Employee> getAll() {
        return entityManager.createQuery("From Employee").getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee getEmployeeByEmployeeId(String employeeId) {
        List<Employee> employeeList = entityManager.createQuery("From Employee e where e.employeeId = :employeeId").setParameter("employeeId", employeeId).getResultList();
        return (employeeList != null && employeeList.size() > 0) ? employeeList.get(0): null;
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
