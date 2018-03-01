package system.model;

public class ClassAndTeacherModel extends ClassModel{
	//id, name, teachercode, teacher, sex, code
	private Integer id;
	private String name;
	private String teachercode;
	private String teacher;
	private String sex;
	private String code;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeachercode() {
		return teachercode;
	}
	public void setTeachercode(String teachercode) {
		this.teachercode = teachercode;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
