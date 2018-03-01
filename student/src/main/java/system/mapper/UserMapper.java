package system.mapper;

import java.util.List;

import system.model.UserModel;

public interface UserMapper {
	
	public UserModel selectByNP(UserModel model);
	public List<UserModel> selectAll (UserModel model);
	public void update(UserModel model);
	public void insert(UserModel model);
	public void delbyid(String id);
	public Integer selectCount(UserModel model);
	public List<UserModel> selectbyclass(UserModel model);

}
