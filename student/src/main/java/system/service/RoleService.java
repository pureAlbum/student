package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.mapper.RoleMapper;
import system.model.RoleModel;

@Service("RoleService")
public class RoleService {
	
	@Autowired
	private RoleMapper mapper;
	
	public RoleMapper getMapper() {
		return mapper;
	}
	
	public RoleModel selectRole(String role) {
		return mapper.selectRole(role);
	}
}
