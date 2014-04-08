package com.konasl.dao;

import com.konasl.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by DELL on 4/8/14.
 */
@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void save(Role role) {
        em.merge(role);
        em.flush();
    }

    @Override
    public Role getRole(int id) {
        return em.find(Role.class, id);
    }
}
