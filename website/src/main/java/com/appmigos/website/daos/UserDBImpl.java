/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appmigos.website.daos;

import com.appmigos.website.dtos.Role;
import com.appmigos.website.dtos.User;
import com.appmigos.website.exceptions.UserDaoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author Isaia
 */
@Component
public class UserDBImpl implements UserDao {

    @Autowired
    JdbcTemplate template;

    @Override
    public User getUserById(int id) throws UserDaoException {
        try {
            User toGet = template.queryForObject("SELECT * FROM Users WHERE id = ?", new UserMapper(), id);
            Set<Role> userRoles = getRolesByUserId(toGet.getId());
            toGet.setRole(userRoles);
            return toGet;
        } catch (DataAccessException ex) {
            throw new UserDaoException("SQL error has occured in getUserById");
        }
    }

    @Override
    public User getUserByName(String name) {
        try {
            User toGet = template.queryForObject("SELECT * FROM Users WHERE username = ?", new UserMapper(), name);
            Set<Role> userRoles = getRolesByUserId(toGet.getId());
            toGet.setRole(userRoles);
            return toGet;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() throws UserDaoException {
        try {
            List<User> allUsers = template.query("SELECT * FROM Users", new UserMapper());
            if (allUsers.size() == 0) {
                throw new UserDaoException("No users found");
            }
            return allUsers;
        } catch (DataAccessException ex) {
            throw new UserDaoException("SQL error has occured in getAllUsers");
        }
    }

    @Override
    public void updateUser(User toEdit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User createUser(User toAdd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Set<Role> getRolesByUserId(int id) {
        return new HashSet<>(template.query("SELECT * FROM Role ro INNER JOIN UserRole ur on ro.id = ur.roleId WHERE ur.userId = ?", new RoleMapper(), id));
    }

    private static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User toReturn = new User();
            toReturn.setId(rs.getInt("id"));
            toReturn.setUserName(rs.getString("userName"));
            toReturn.setPassword(rs.getString("password"));
            toReturn.setEnabled(rs.getBoolean("enabled"));
            return toReturn;
        }
    }

    private static class RoleMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet rs, int i) throws SQLException {
            Role toReturn = new Role();
            toReturn.setId(rs.getInt("id"));
            toReturn.setRole(rs.getString("role"));
            return toReturn;
        }
    }

}
