package attendance.model;

import system.model.PageModel;

public class AttendanceModel extends PageModel{
	//考勤表
	//id, userid, date, 1st, 2nd, 3rd, 4th, 5th, 6th
	private Integer id;
	private String userid;
	private String date;
	private String date1st;
	private String date2nd;
	private String date3rd;
	private String date4th;
	private String date5th;
	private String date6th;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate1st() {
		return date1st;
	}
	public void setDate1st(String date1st) {
		this.date1st = date1st;
	}
	public String getDate2nd() {
		return date2nd;
	}
	public void setDate2nd(String date2nd) {
		this.date2nd = date2nd;
	}
	public String getDate3rd() {
		return date3rd;
	}
	public void setDate3rd(String date3rd) {
		this.date3rd = date3rd;
	}
	public String getDate4th() {
		return date4th;
	}
	public void setDate4th(String date4th) {
		this.date4th = date4th;
	}
	public String getDate5th() {
		return date5th;
	}
	public void setDate5th(String date5th) {
		this.date5th = date5th;
	}
	public String getDate6th() {
		return date6th;
	}
	public void setDate6th(String date6th) {
		this.date6th = date6th;
	}

}
