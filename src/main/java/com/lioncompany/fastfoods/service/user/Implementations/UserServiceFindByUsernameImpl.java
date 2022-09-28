package com.lioncompany.fastfoods.service.user.Implementations;

import com.lioncompany.fastfoods.dao.IUserDao;
import com.lioncompany.fastfoods.dto.UserTO;
import com.lioncompany.fastfoods.entity.User;
import com.lioncompany.fastfoods.service.user.Interfaces.IUserServiceFindByUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceFindByUsernameImpl implements IUserServiceFindByUsername {

    @Autowired
    private IUserDao userDao;

    @Override
    public User execute(UserTO userTO) {
        return userDao.findByUsername(userTO.getUsername());
    }

}
