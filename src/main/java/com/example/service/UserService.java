package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.InvalidCredentialsException;
import com.example.model.DiagnosticCenter;
import com.example.model.Users;
import com.example.repository.UserRepository;
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public Users saveUser(Users users) {
		return userRepo.save(users);
	}

	public List<Users> getAll() {

		return userRepo.findAll();

	}

	public String removeUser(Integer userId) {
		Users user = userRepo.getReferenceById(userId);
		if (userRepo.existsById(userId)) {
			userRepo.deleteById(userId);
			return "User " + userId + " deleted successfully";
		} else
			return "UserId does not exists";

	}

	public String getUserById(Integer userId) {
		if (userRepo.existsById(userId)) {
			Users user = userRepo.getReferenceById(userId);
			return "User Found\n" + user;
		} else
			return "UserId Not Found";
	}



	
	public String login(Integer userId, String password) throws InvalidCredentialsException {
		if (userRepo.existsById(userId)) {
			Users user1 = userRepo.getReferenceById(userId);
			if (user1.getPassword().equals(password)) {
				return "Successful login";
			}
		}
		return "Please Check Credentials";
	}
	
	public String addUser(Users user) {
		if (user.getPassword().isEmpty() || user.getUsername().isEmpty() || user.getContact().isEmpty()
				|| user.getEmail().isEmpty() ) {
			return "Please fill all fields";
		} else if (user.getContact().length() > 10 || user.getContact().length() < 10) {
			return "Invalid Phone number";
		} else if (!(user.getEmail().contains("@gmail.com"))) {
			return "Invalid Email Id";
		} else {
			userRepo.save(user);
			return "User Added Successfully!!\nYour UserId is " + user.getId();
		}
	}
	
	
	
//	public  String updateUser(Integer id, Users user) {
//		Users user1 = userRepo.getReferenceById(id);
//		if (userRepo.existsById(id)) {
//			if (user.getPassword().isEmpty() || user.getUserRole().isEmpty() || user.getContactNo().isEmpty()
//					|| user.getEmail().isEmpty() || user.getUserName().isEmpty()) {
//				return "Please fill all fields";
//			} else if (user.getContactNo().length() > 10 || user.getContactNo().length() < 10) {
//				return "Invalid Phone number";
//			} else if (!(user.getEmail().contains("@gmail.com"))) {
//				return "Invalid Email Id";
//			}else {
//			user1.setUserName(user.getUserName());
//			user1.setEmail(user.getEmail());
//			user1.setContactNo(user.getContactNo());
//			userRepo.save(user1);
//			return "Updated " + user1;
//			}
//
//		} else {
//			return "UserID Not Found";
//		}
//	}
	
	public Users updateUser(Users obj) {
		return userRepo.save(obj);
	}


	

	
}
