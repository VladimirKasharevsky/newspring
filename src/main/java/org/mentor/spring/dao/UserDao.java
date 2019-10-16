package org.mentor.spring.dao;

import org.mentor.spring.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);

    void deleteUser(String id);

    void updateUser(User user);

    List<User> selectData() ; //List<User>

    User selectDataById(String id);

    User selectDataByLoginPassword(User user);

}
