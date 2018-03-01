package attendance.mapper;

import java.util.List;

import attendance.model.AddAttendanceModel;
import attendance.model.AttendanceModel;

public interface AttendanceMapper {
	public List<AttendanceModel> selectbyuser(AttendanceModel attend);
	public Integer selectcount(AttendanceModel attend);
	public List<AddAttendanceModel> selectandname(AttendanceModel attend);
	public void update(AttendanceModel model);
	public void insert(AttendanceModel model);
	public void delbyid(String id);
}
