package me.nibo.spring.security.controller;

import me.nibo.spring.security.model.User;
import me.nibo.spring.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 *
 * @author NiBo
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> add(@RequestBody User user) {
        userService.add(user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody User user) {
        LOGGER.debug("用户 id：{}", id);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable String id) {
        LOGGER.debug("用户 id：{}", id);
        return ResponseEntity.ok("用户删除成功");
    }

}
