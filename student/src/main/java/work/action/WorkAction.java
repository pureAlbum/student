package work.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import system.model.UserModel;
import work.model.HomeworkModel;
import work.model.WorkendModel;
import work.service.WorkService;

@Controller
@RequestMapping("/work")
public class WorkAction {

	@Autowired
	private WorkService service;
	@RequestMapping(value="/selecthw.do",produces= "text/html;charset=UTF-8" )
	@ResponseBody
	public String selecthw(HttpServletRequest request,Integer rows,Integer page) {
		UserModel user=(UserModel)request.getSession().getAttribute("user");
		System.out.println(user.getRole());
		HomeworkModel home=new HomeworkModel();
		home.setPage(page);
		home.setRows(rows);
		if(user.getRole().equals("2")) {
			home.setTeachercode(user.getCode());
		}
		List<HomeworkModel> list=service.selectAll(home);
		Integer total=service.selectCount(home);
		//String total=Integer.parseUnsignedInt(service.selectAll(null).size());
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", total);
        jsonMap.put("rows", list);
        JSONObject json2=JSONObject.fromObject(jsonMap);
        System.out.println(json2.toString());
		return json2.toString() ;
	}
	
	@RequestMapping(value = "/del.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String delbyid (String id) {
		service.delbyid(id);
		return "1";
	}
	
	@RequestMapping(value = "/insert.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String insert ( HttpServletRequest request,HomeworkModel model) {
		System.out.println("接收的数据：");
		//System.out.println(us.getName());
		UserModel user=(UserModel)request.getSession().getAttribute("user");
		model.setTeachercode(user.getCode());
		service.insert(model);
		return "1";
	}
	
	@RequestMapping(value = "/update.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String update (HomeworkModel model) {
		//System.out.println("进入update");
		//System.out.println("接收的数据：");
		//System.out.println(user.getId());
		service.update(model);
		return "1";
	}
	@RequestMapping(value="/selecthw2.do",produces= "text/html;charset=UTF-8" )
	@ResponseBody
	public String selecthw2(HttpServletRequest request,Integer rows,Integer page) {
		UserModel user=(UserModel)request.getSession().getAttribute("user");
		System.out.println(user.getRole());
		WorkendModel home=new WorkendModel();
		home.setPage(page);
		home.setRows(rows);
		home.setUserid(user.getCode());
		if(user.getRole().equals("2")||user.getRole().equals("3")) {
			home.setUserid(null);
		}
		List<WorkendModel> list=service.selectAll2(home);
		Integer total=service.selectCount2(home);
		//String total=Integer.parseUnsignedInt(service.selectAll(null).size());
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", total);
        jsonMap.put("rows", list);
        JSONObject json2=JSONObject.fromObject(jsonMap);
        System.out.println(json2.toString());
		return json2.toString() ;
	}
	
	@RequestMapping(value = "/del2.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String delbyid2 (String id) {
		service.delbyid2(id);
		return "1";
	}
	
	@RequestMapping(value = "/insert2.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String insert2 ( HttpServletRequest request,WorkendModel model) {
		System.out.println("接收的数据：");
		//System.out.println(us.getName());
		//UserModel user=(UserModel)request.getSession().getAttribute("user");
		//model.WorkendModel(user.getCode());
		service.insert2(model);
		return "1";
	}
	
	@RequestMapping(value = "/update2.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String update2 (WorkendModel model) {
		//System.out.println("进入update");
		//System.out.println("接收的数据：");
		//System.out.println(user.getId());
		service.update2(model);
		return "1";
	}
}
