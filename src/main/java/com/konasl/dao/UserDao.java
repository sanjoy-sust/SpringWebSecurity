package com.konasl.dao;

import com.konasl.model.User;

/**
 * Created by DELL on 4/8/14.
 */
public interface UserDao {
    public void save(User user);

    public User getUser(String login);
}
