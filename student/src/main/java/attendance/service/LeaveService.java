package attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import attendance.mapper.LeaveMapper;
import attendance.model.LeaveModel;

@Service("LeaveService")
public class LeaveService {
	
	@Autowired
	private LeaveMapper mapper;
	
	public List<LeaveModel> selectbyid(LeaveModel model){
		return mapper.selectbyid(model);
	};
	
	public void addnew(LeaveModel model) {
		mapper.addnew(model);
	}
	
	public void delapplication(String id) {
		mapper.delapplication(id);
	}
	
	public void update(LeaveModel model) {
		mapper.update(model);
	}
  }
