package com.konasl.dao;

import com.konasl.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by DELL on 4/8/14.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void save(User user) {
        em.merge(user);
        em.flush();
    }

    @Override
    public User getUser(String login) {
        Query query = em.createQuery("from User user where user.login = :login");
        query.setParameter("login", login);
        return (User) query.getResultList().get(0);
    }
}
