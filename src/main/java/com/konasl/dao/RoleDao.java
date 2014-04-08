package com.konasl.dao;

import com.konasl.model.Role;

/**
 * Created by DELL on 4/8/14.
 */
public interface RoleDao {
    public void save(Role role);

    public Role getRole(int id);
}
