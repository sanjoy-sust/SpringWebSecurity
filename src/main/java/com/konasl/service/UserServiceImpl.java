package com.konasl.service;

import com.konasl.dao.UserDao;
import com.konasl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by DELL on 4/8/14.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String login) {
        return userDao.getUser(login);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }
}
