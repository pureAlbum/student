package work.model;

import system.model.PageModel;

public class WorkendModel extends PageModel{
//id, userid, workcode, oneself_score, teacher_score
	private Integer id;
	private String userid;
	private String workcode;
	private String oneselfScore;
	private String teacherScore;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getWorkcode() {
		return workcode;
	}
	public void setWorkcode(String workcode) {
		this.workcode = workcode;
	}
	public String getOneselfScore() {
		return oneselfScore;
	}
	public void setOneselfScore(String oneselfScore) {
		this.oneselfScore = oneselfScore;
	}
	public String getTeacherScore() {
		return teacherScore;
	}
	public void setTeacherScore(String teacherScore) {
		this.teacherScore = teacherScore;
	}
}
