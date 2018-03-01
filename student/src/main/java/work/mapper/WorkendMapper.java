package work.mapper;

import java.util.List;

import work.model.HomeworkModel;
import work.model.WorkendModel;

public interface WorkendMapper {
	public List<WorkendModel> selectAll2(WorkendModel model);
	public int selectCount2(WorkendModel model);
	public void update2(WorkendModel model);
	public void insert2(WorkendModel model);
	public void delbyid2(String id);
}
