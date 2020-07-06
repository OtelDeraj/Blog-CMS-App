/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appmigos.website.daos;

import com.appmigos.website.dtos.Role;
import java.util.List;

/**
 *
 * @author Isaia
 */
public interface RoleDao {
    
    public Role getRoleById(int id);
    
    public Role getRoleByName(String name);
    
    public List<Role> getAllRoles();
    
    public void updateRole(Role toEdit);
    
    public void removeRole(int id);
    
    public Role createRole(Role toAdd);
}
