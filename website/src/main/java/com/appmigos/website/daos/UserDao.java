/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appmigos.website.daos;

import com.appmigos.website.dtos.User;
import com.appmigos.website.exceptions.UserDaoException;
import java.util.List;

/**
 *
 * @author Isaia
 */
public interface UserDao {
 
    public User getUserById(int id) throws UserDaoException;
    
    public User getUserByName(String name) throws UserDaoException;
    
    public List<User> getAllUsers() throws UserDaoException;
    
    public void updateUser(User toEdit) throws UserDaoException;
    
    public void deleteUser(int id) throws UserDaoException;
    
    public User createUser(User toAdd) throws UserDaoException;
    
}
