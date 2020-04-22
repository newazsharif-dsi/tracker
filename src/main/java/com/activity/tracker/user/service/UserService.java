package com.activity.tracker.user.service;

import com.activity.tracker.model.User;
import com.activity.tracker.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getUserByUserName(String username) {
        return userDao.getUserByUserName(username);
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public void save(User user) {
        userDao.saveOrUpdate(user);
    }

}
