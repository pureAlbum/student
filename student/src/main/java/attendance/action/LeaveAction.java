package attendance.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import attendance.model.LeaveModel;
import attendance.service.LeaveService;
import net.sf.json.JSONArray;
import system.model.UserModel;
import system.service.UserService;

@Controller
@RequestMapping("/leave")
public class LeaveAction {

	@Autowired
	private LeaveService service;
	
	@Autowired
	private UserService userService;
	
	private String role=null;
	
	@RequestMapping(value="/selectbyid.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String select(HttpServletRequest request){
		Object ou = request.getSession().getAttribute("user");
		UserModel user=(UserModel)ou;
		LeaveModel model=new LeaveModel();
		model.setUser_code(user.getCode());
		List<LeaveModel> list = service.selectbyid(model);
		JSONArray json=JSONArray.fromObject(list);
		return json.toString();
	}
	
	@RequestMapping("/addnew.do")
	@ResponseBody
	public String addnew(HttpServletRequest request , LeaveModel model) {
		System.out.println("执行了一次");
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		Object ou = request.getSession().getAttribute("user");
		UserModel user=(UserModel)ou;
		model.setTime(time);
		String status="申请中 ";
		model.setStatus(status);
		model.setUser_code(user.getCode());
		service.addnew(model);
		return "1";
	}
	
	@RequestMapping("/delapplication.do")
	@ResponseBody
	public String del(String id) {
		System.out.println(id);
		service.delapplication(id);
		return "1";
	}
	
	@RequestMapping(value="/selectbyclass.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String selectbyclass(HttpServletRequest request) {
		Object uu=request.getSession().getAttribute("user");
		UserModel user = (UserModel)uu;
		this.role=user.getRole();
		//String classCode=user.getClassCode();
		user.page=1;
		List<UserModel> liu= userService.selectbyclass(user);
		System.out.println(role);
		if(role.equals("3")) {
			user.page=1;
			liu=userService.selectAll(user);
		}
		List<LeaveModel> lia= new ArrayList<LeaveModel>();
		for(UserModel u1:liu) {
			LeaveModel model= new LeaveModel();
			model.setUser_code(u1.getCode());
			List<LeaveModel> liaa = service.selectbyid(model);
			lia.addAll(liaa);
		}
		JSONArray json=JSONArray.fromObject(lia);
		return json.toString();
	}
	
	@RequestMapping("/updatestatus.do")
	@ResponseBody
	public String update(LeaveModel model) {
		//System.out.println(model.getId());
		String status=model.getStatus();
		if(status.equals("批准")) {
			status="讲师:批准";
			if(role.equals("3")) {
				status="已复批";
			}
			model.setStatus(status);
		}else if(status.equals("驳回")) {
			status="讲师:驳回";
			if(role.equals("3")) {
				status="驳回";
			}
			model.setStatus(status);
		}else{
			
		}
		service.update(model);
		//System.out.println(model.getStatus());
		return null;
	} 
}
