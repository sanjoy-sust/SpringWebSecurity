package com.konasl.service;

import com.konasl.dao.RoleDao;
import com.konasl.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by DELL on 4/8/14.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    public Role getRole(int id) {
        return roleDao.getRole(id);
    }
}
