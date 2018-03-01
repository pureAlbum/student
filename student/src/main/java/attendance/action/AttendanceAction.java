package attendance.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import attendance.model.AddAttendanceModel;
import attendance.model.AttendanceModel;
import attendance.service.AttendanceService;
import net.sf.json.JSONObject;
import system.model.UserModel;

@Controller
@RequestMapping("/attendance")
public class AttendanceAction {
	
	@Autowired
	private AttendanceService service;
	
	@RequestMapping("/selectuser.do")
	@ResponseBody
	public String select(HttpServletRequest request ,Integer rows,Integer page,String date) {
		AttendanceModel attend=new AttendanceModel();
		attend.page=page;
		attend.rows=rows;
		UserModel user=(UserModel)request.getSession().getAttribute("user");
		attend.setUserid(user.getCode());
		System.out.println(user.getCode());
		if(date != null || !"".equals(date)) {
			attend.setDate(date);
		}
		List<AttendanceModel> list =service.selectbyuser(attend);
		Integer total= service.selectcount(attend);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", total);
        jsonMap.put("rows", list);
		JSONObject json=JSONObject.fromObject(jsonMap);
		return json.toString();
	}
	
	@RequestMapping("/selectteacher.do")
	@ResponseBody
	public String selectteacher(HttpServletRequest request ,Integer rows,Integer page,String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");//设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间
		System.out.println(time);
		System.out.println(date);
		AttendanceModel attend=new AttendanceModel();
		attend.page=page;
		attend.rows=rows;
		attend.setDate(time);
		if(date != null || !"".equals(date)) {
			attend.setDate(date);
		}
		List<AddAttendanceModel> list =service.selectandname(attend);
		for(AddAttendanceModel list1:list) {
			System.out.println(list1.getId());
		}
		Integer total= service.selectcount(attend);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", total);
        jsonMap.put("rows", list);
		JSONObject json=JSONObject.fromObject(jsonMap);
		return json.toString();
		
	}
	@RequestMapping(value = "/del.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String delbyid (String id) {
		service.delbyid(id);
		return "1";
	}
	
	@RequestMapping(value = "/addattend.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String insert (AttendanceModel model) {
		System.out.println("添加");
		System.out.println(model.getDate());
		System.out.println(model.getUserid());
		service.insert(model);
		return "1";
	}
	
	@RequestMapping(value = "/upattr.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String update (AttendanceModel model) {
		System.out.println("进入update");
		System.out.println("接收的数据：");
		System.out.println(model.getId());
		service.update(model);
		return "1";
	}
}
