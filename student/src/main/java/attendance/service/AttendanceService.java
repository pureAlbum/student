 package attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import attendance.mapper.AttendanceMapper;
import attendance.model.AddAttendanceModel;
import attendance.model.AttendanceModel;

@Service("AttendanceService")
public class AttendanceService {
	
	@Autowired
	private AttendanceMapper mapper;
	
	public AttendanceMapper getMapper() {
		return mapper;
	}
	
	public List<AttendanceModel> selectbyuser(AttendanceModel attend) {
		Integer rows=attend.rows;
		Integer page=attend.page;
		page=(page-1)*rows;
		attend.setPage(page);
		return mapper.selectbyuser(attend);
	}
	
	public Integer selectcount (AttendanceModel attend) {
		return mapper.selectcount(attend);
	}
	
	public List<AddAttendanceModel> selectandname(AttendanceModel attend){
		Integer rows=attend.rows;
		Integer page=attend.page;
		page=(page-1)*rows;
		attend.setPage(page);
		return mapper.selectandname(attend);
	}
	
	public void update(AttendanceModel model) {
		mapper.update(model);
	}
	public void insert(AttendanceModel model) {
		mapper.insert(model);
	}
	public void delbyid(String id) {
		mapper.delbyid(id);
	}
}
