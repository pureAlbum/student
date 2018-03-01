package system.mapper;

import system.model.ClassAndTeacherModel;
import system.model.ClassModel;

public interface ClassMapper {
	public ClassModel selectName(String id);
	public ClassAndTeacherModel classandteacher(String id);

}
