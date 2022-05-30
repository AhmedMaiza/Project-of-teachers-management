package com.ahmed.enseignants.service;

import java.util.List;

import com.ahmed.enseignants.entities.Role;

public interface RoleService {

	List <Role> findAll();
	Role findByRole(String role);



}
