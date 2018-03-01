package system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.mapper.PermissionMapper;
import system.model.RolePerModel;
import system.model.UserModel;

@Service("PermissionService")
public class PermissionService {
	
	@Autowired
	private PermissionMapper permissionMapper;
	
	public PermissionMapper getMapper() {
		return permissionMapper;
	}

	public List<RolePerModel> selectPer (UserModel model) {
		return getMapper().selectPer(model);
	}
}
