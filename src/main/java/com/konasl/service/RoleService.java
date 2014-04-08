package com.konasl.service;

import com.konasl.model.Role;

/**
 * Created by DELL on 4/8/14.
 */
public interface RoleService {
    public void save(Role role);

    public Role getRole(int id);
}
