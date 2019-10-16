package org.mentor.spring.service;

import org.mentor.spring.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user) ;

    void deleteUser(String id);

    List listData();

    void updateUser(User user);

    User getUserById(String id);
}
