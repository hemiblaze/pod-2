package com.prototype.auditauthentication.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.prototype.auditauthentication.model.ProjectManager;
import com.prototype.auditauthentication.repository.ManagerRepo;

@Service
public class ManagerService implements UserDetailsService {

	@Autowired
	ManagerRepo managerRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ProjectManager  manager = managerRepo.findById(username).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email: " + username));
		return new User(manager.getUserId(),manager.getPassword(),new ArrayList<>());
	}

	public void saveUser(ProjectManager projectManager) {

		managerRepo.save(projectManager);
	}

}
