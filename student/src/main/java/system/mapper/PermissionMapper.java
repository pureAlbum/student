package system.mapper;

import java.util.List;

import system.model.RolePerModel;
import system.model.UserModel;

public interface PermissionMapper {
	public List<RolePerModel> selectPer(UserModel model);
}
