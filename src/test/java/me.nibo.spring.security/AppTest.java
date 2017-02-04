package me.nibo.spring.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

/**
 * Created by richard on 2017/1/22.
 */
@RunWith(JUnit4.class)
public class AppTest {
    @Test
    public void testUUID() {
        System.out.println(UUID.fromString(UUID.randomUUID().toString()).toString());
        System.out.println(UUID.randomUUID().toString());
        System.out.println(new BCryptPasswordEncoder().encode("abc123"));
    }
}
