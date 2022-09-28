package com.lioncompany.fastfoods.service.user.Implementations;

import com.lioncompany.fastfoods.dto.UserTO;
import com.lioncompany.fastfoods.entity.User;
import com.lioncompany.fastfoods.service.user.Interfaces.IUserServiceFindByUsername;
import com.lioncompany.fastfoods.service.user.Interfaces.IUserServiceLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceLoginImpl implements IUserServiceLogin {

    @Autowired
    private IUserServiceFindByUsername userServiceFindByUsername;
    private PasswordEncoder passwordEncoder;

    @Override
    public User execute(UserTO userTO) {
        User user = userServiceFindByUsername.execute(userTO);
        return loginValidation(user, userTO);
    }

    private User loginValidation(User user, UserTO userTO) {

        this.passwordEncoder = new BCryptPasswordEncoder();
        String dbPassword = user.getPassword();
        boolean isPasswordsMatches = passwordEncoder.matches(userTO.getPassword(), dbPassword);

        if(user != null && isPasswordsMatches){
            return user;
        }

        return null;
    }
}
