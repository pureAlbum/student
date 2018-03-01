package work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.mapper.HomeworkMapper;
import work.mapper.WorkendMapper;
import work.model.HomeworkModel;
import work.model.WorkendModel;

@Service("WorkService")
public class WorkService {
	
	@Autowired
	private HomeworkMapper homeworkmapper;
	@Autowired
	private WorkendMapper  workendmapper;
	public HomeworkMapper getHomeworkmapper() {
		return homeworkmapper;
	}
	public WorkendMapper getWorkendmapper() {
		return workendmapper;
	}
	public List<HomeworkModel> selectAll(HomeworkModel model){
		Integer rows=model.rows;
		Integer page=model.page;
		page=(page-1)*rows;
		model.setPage(page);
		return homeworkmapper.selectAll(model);	
	}
	
	public void update(HomeworkModel model) {
		homeworkmapper.update(model);
	}
	public void insert(HomeworkModel model) {
		homeworkmapper.insert(model);
	}
	public void delbyid(String id) {
		homeworkmapper.delbyid(id);
	}
	public Integer selectCount(HomeworkModel model) {
		return homeworkmapper.selectCount(model);
	}
	public List<WorkendModel> selectAll2(WorkendModel model){
		Integer rows=model.rows;
		Integer page=model.page;
		page=(page-1)*rows;
		model.setPage(page);
		return workendmapper.selectAll2(model);	
	}
	
	public void update2(WorkendModel model) {
		workendmapper.update2(model);
	}
	public void insert2(WorkendModel model) {
		workendmapper.insert2(model);
	}
	public void delbyid2(String id) {
		workendmapper.delbyid2(id);
	}
	public Integer selectCount2(WorkendModel model) {
		return workendmapper.selectCount2(model);
	}
}
