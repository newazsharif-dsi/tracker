package com.activity.tracker.user.dao;


import com.activity.tracker.model.User;

import java.util.List;


public interface UserDao {
    public User getUserByUserName(String username);
    public List<User> getAllUser();
    public void update(User user);
    public void save(User user);
    public void saveOrUpdate(User user);
    public void delete(User user);
}
