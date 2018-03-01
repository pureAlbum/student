package system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.mapper.UserMapper;
import system.model.UserModel;

@Service("UserService")
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	public UserMapper getMapper() {
		return mapper;
	}
	
	public UserModel selectByNP(UserModel model) {
		return mapper.selectByNP(model);
	}
	
	public List<UserModel> selectAll(UserModel model){
		Integer rows=model.rows;
		Integer page=model.page;
		page=(page-1)*rows;
		model.setPage(page);
		return mapper.selectAll(model);	
	}
	
	public void update(UserModel model) {
		mapper.update(model);
	}
	public void insert(UserModel model) {
		mapper.insert(model);
	}
	public void delbyid(String id) {
		mapper.delbyid(id);
	}
	public Integer selectCount(UserModel model) {
		return mapper.selectCount(model);
	}
	
	public List<UserModel> selectbyclass(UserModel model){
		Integer rows=model.rows;
		Integer page=model.page;
		page=(page-1)*rows;
		model.setPage(page);
		return mapper.selectbyclass(model);
	}
}
