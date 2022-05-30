package com.ahmed.enseignants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ahmed.enseignants.entities.Role;
import com.ahmed.enseignants.entities.User;
import com.ahmed.enseignants.repos.RoleRepository;
import com.ahmed.enseignants.repos.UserRepository;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	RoleRepository roleRep;

	@Override
	public List<User> findAll() {
		return UserRepository.findAll();
	}

	@Override
	public User saveUser(User e) {
		return UserRepository.save(e);
	}
	
	@Override
	public User addRoleToUser(String username, String rolename) {
		User usr = UserRepository.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		
		usr.getRoles().add(r);
		return usr;
	}

	@Override
	public User updateUser(User e) {
		return UserRepository.save(e);
	}

	@Override
	public void deleteUser(User e) {
		UserRepository.delete(e);
		
	}

	@Override
	public void deleteUserById(Long id) {
		UserRepository.deleteById(id);		
	}

	@Override
	public User getUser(Long id) {
		return UserRepository.getById(id);
	}

	@Override
	public Page<User> getAllUsersParPage(int page, int size) {
		return UserRepository.findAll(PageRequest.of(page, size));
	}
	


	@Override
	public User findUserByUsername(String username) {	
		return UserRepository.findByUsername(username);
	}

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

}
