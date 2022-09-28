package com.lioncompany.fastfoods.service.user.Interfaces;

import com.lioncompany.fastfoods.dto.UserTO;
import com.lioncompany.fastfoods.entity.User;

public interface IUserServiceFindByUsername {
	User execute(UserTO userTO);
}
