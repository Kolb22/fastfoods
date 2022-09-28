package com.lioncompany.fastfoods.service.user.Implementations;

import com.lioncompany.fastfoods.dao.IUserDao;
import com.lioncompany.fastfoods.dto.UserTO;
import com.lioncompany.fastfoods.entity.User;
import com.lioncompany.fastfoods.service.user.Interfaces.IUserServiceSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceSaveImpl implements IUserServiceSave {

	@Autowired
	private IUserDao userDao;
	
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public User execute(UserTO userTO) {
		
		User user = new User();
		String unique = UUID.randomUUID().toString().substring(0, 6);
		this.passwordEncoder = new BCryptPasswordEncoder();

		if(userTO != null) {
			
			user.setPassword(passwordEncoder.encode(userTO.getPassword()));
			user.setUsername(userTO.getUsername());
			
		}
		
		return userDao.save(user);
	}

}
