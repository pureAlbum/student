package attendance.mapper;

import java.util.List;

import attendance.model.LeaveModel;

public interface LeaveMapper {
	public List<LeaveModel> selectbyid(LeaveModel model);
	public void addnew(LeaveModel model);
	public void delapplication(String id);
	public void update(LeaveModel model);
}
