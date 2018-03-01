package attendance.model;

public class AddAttendanceModel extends AttendanceModel{
	// a.id, userid, date, 1st, 2nd, 3rd, 4th, 5th, 6th, name, code
	private Integer id;
	private String name;
	private String code;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
