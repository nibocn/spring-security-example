package me.nibo.spring.security.dao;

import me.nibo.spring.security.model.User;

import java.util.List;

/**
 * @author NiBo
 */
public interface UserMapper {
    void insert(User user);

    User get(String username);

    List<User> query();
}
