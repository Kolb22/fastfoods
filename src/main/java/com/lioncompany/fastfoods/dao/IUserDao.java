package com.lioncompany.fastfoods.dao;

import com.lioncompany.fastfoods.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

