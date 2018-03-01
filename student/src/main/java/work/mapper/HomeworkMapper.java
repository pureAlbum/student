package work.mapper;

import java.util.List;

import work.model.HomeworkModel;

public interface HomeworkMapper {

	public List<HomeworkModel> selectAll(HomeworkModel model);
	public int selectCount(HomeworkModel model);
	public void update(HomeworkModel model);
	public void insert(HomeworkModel model);
	public void delbyid(String id);
}
