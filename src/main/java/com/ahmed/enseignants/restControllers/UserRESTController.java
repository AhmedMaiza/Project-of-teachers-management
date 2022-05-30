package com.ahmed.enseignants.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.enseignants.entities.Enseignant;
import com.ahmed.enseignants.entities.Role;
import com.ahmed.enseignants.entities.User;
import com.ahmed.enseignants.service.UserService;

@RestController
@RequestMapping("/apii")
@CrossOrigin
public class UserRESTController {

	@Autowired
	UserService userService;
	
	/*
	 @Override
	public User addRoleToUser(String username, String rolename) {
		User usr = UserRepository.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		
		usr.getRoles().add(r);
		return usr;
	}
	 */
	
	//@RequestMapping(method = RequestMethod.PUT)
	@RequestMapping(value="/{nom}/{role}",method = RequestMethod.PUT)
	public User changeUser(@PathVariable("nom") String nom, @PathVariable("role") String role ) {
		
	User abc= userService.addRoleToUser(nom,role);
	return userService.updateUser(abc);
	}
}
