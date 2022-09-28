package com.lioncompany.fastfoods.controller;

import com.lioncompany.fastfoods.dto.UserTO;
import com.lioncompany.fastfoods.entity.User;
import com.lioncompany.fastfoods.service.user.Interfaces.IUserServiceLogin;
import com.lioncompany.fastfoods.service.user.Interfaces.IUserServiceSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin({"*"})
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private IUserServiceSave userServiceSave;

	@Autowired
	private IUserServiceLogin userServiceLogin;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserTO userTO) {
		User user;
		Map<String, Object> errorResponse = new HashMap<>();

		try{
			user = userServiceSave.execute(userTO);
		} catch (Exception e){
			errorResponse.put("error", "Something has happened trying to register the user. Please try again later.");
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserTO userTO) {
		User user;
		Map<String, Object> errorResponse = new HashMap<>();

		try{
			user = userServiceLogin.execute(userTO);
		} catch (Exception e){
			errorResponse.put("error", "Something has happened trying to login. Please try again later.");
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(user == null) {
			errorResponse.put("error", "The email or password is incorrect. Please try again.");
			return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
