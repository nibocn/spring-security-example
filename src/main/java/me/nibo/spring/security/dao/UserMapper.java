package me.nibo.spring.security.dao;

import me.nibo.spring.security.model.User;

/**
 * @author NiBo
 */
public interface UserMapper {
    void insert(User user);
}
