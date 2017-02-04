package me.nibo.spring.security.security;

import com.google.common.collect.Lists;
import me.nibo.spring.security.dao.UserMapper;
import me.nibo.spring.security.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Spring Security UserDetailsService 接口实现
 *
 * @author NiBo
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.get(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(username);
        }
        LOGGER.debug(user.toString());

        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        List<String> list = initAuthorities(username);
        for (String s : list) {
            roles.add(new SimpleGrantedAuthority(s));
        }

        return new CustomUserDetails(username, user.getPassword(), roles);
    }

    private List<String> initAuthorities(String username) {
        if ("admin".equals(username)) {
            return Lists.newArrayList("USER_LIST", "USER_DELETE", "USER_ADD", "USER_UPDATE");
        } else if ("richard".equals(username)) {
            return Lists.newArrayList("USER_LIST", "USER_DELETE");
        } else {
            return Lists.newArrayList("USER");
        }
    }

}
