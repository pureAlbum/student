package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.mapper.ClassMapper;
import system.model.ClassAndTeacherModel;
import system.model.ClassModel;

@Service("ClassService")
public class ClassService {
	
	@Autowired
	private ClassMapper mapper;
	
	public ClassMapper getMapper() {
		return mapper;
	}
	
	public ClassModel selectName(String id) {
		return mapper.selectName(id);
	}
	public ClassAndTeacherModel classandteacher(String id) {
		return mapper.classandteacher(id);
	}
}
