/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appmigos.website.daos;

import com.appmigos.website.dtos.User;
import java.util.List;

/**
 *
 * @author Isaia
 */
public interface UserDao {
 
    public User getUserById(int id);
    
    public User getUserByName(String name);
    
    public List<User> getAllUsers();
    
    public void updateUser(User toEdit);
    
    public void deleteUser(int id);
    
    public User createUser(User toAdd);
    
}
