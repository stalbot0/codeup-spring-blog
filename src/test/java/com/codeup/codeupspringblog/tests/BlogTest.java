package com.codeup.codeupspringblog.tests;

import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Transactional(rollbackOn = {SQLException.class})
@Rollback(value = false)
public class BlogTest {

    @Autowired
    private UserRepository usersDao;

    @Test
    public void fetchUsers() {
        List<User> users = usersDao.findAll();
        System.out.println(users);
    }
}
