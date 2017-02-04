package me.nibo.spring.security.service;

import me.nibo.spring.security.dao.UserMapper;
import me.nibo.spring.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author NiBo
 */
@Transactional
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void add(User user) {
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userMapper.insert(user);
    }

    public List<User> query() {
        return userMapper.query();
    }
}
