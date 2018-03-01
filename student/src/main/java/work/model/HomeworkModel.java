package work.model;

import system.model.PageModel;

public class HomeworkModel extends PageModel{
	//id, teachercode, tm, grade_standard, type
	private Integer id;
	private String teachercode;
	private String tm;
	private String gradeStandard;
	private String type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeachercode() {
		return teachercode;
	}
	public void setTeachercode(String teachercode) {
		this.teachercode = teachercode;
	}
	public String getTm() {
		return tm;
	}
	public void setTm(String tm) {
		this.tm = tm;
	}
	public String getGradeStandard() {
		return gradeStandard;
	}
	public void setGradeStandard(String gradeStandard) {
		this.gradeStandard = gradeStandard;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
