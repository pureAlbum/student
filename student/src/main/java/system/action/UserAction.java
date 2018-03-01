package system.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import system.model.RolePerModel;
import system.model.UserModel;
import system.service.PermissionService;
import system.service.UserService;

@RequestMapping("/user")
@Controller
public class UserAction {
	
	@Autowired
	@Qualifier("UserService")
	public UserService service;
	
	@Autowired
	public PermissionService permissionService;
	
	@RequestMapping("/login.do")
	public String Login(HttpServletRequest request) {
		String code = request.getParameter("code");
		String pass = request.getParameter("pass");
		UserModel model = new UserModel();
		UserModel res = new UserModel();
		model.setCode(code);
		model.setPass(pass);
		res = service.selectByNP(model);
		if (res == null) {
			request.setAttribute("mail", "失败");
			return "index";
		}
		List<RolePerModel> list = permissionService.selectPer(res);
		System.out.println(list.size());
		request.getSession().setAttribute("user", res);
		request.getSession().setAttribute("roleper", list);
		request.setAttribute("mail", "成功");
		return "main";
	}
	
	@RequestMapping("/exit.do")
	public String exit(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "index";
	}
	
	@RequestMapping(value = "/select.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String selectall(HttpServletRequest request,Integer rows,Integer page) {
		UserModel user=(UserModel)request.getSession().getAttribute("user");
		System.out.println(user.getRole());
		user.setPage(page);
		user.setRows(rows);
		List<UserModel> list=service.selectAll(user);
		Integer total=service.selectCount(null);
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
	public String insert (UserModel user) {
		System.out.println("接收的数据：");
		System.out.println(user.getName());
		service.insert(user);
		return "1";
	}
	
	@RequestMapping(value = "/update.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String update (UserModel user) {
		System.out.println("进入update");
		System.out.println("接收的数据：");
		System.out.println(user.getId());
		service.update(user);
		return "1";
	}
	
	@RequestMapping(value = "/selectbyclass.do",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String selectbyclass(HttpServletRequest request,Integer rows,Integer page) {
		UserModel user=(UserModel)request.getSession().getAttribute("user");
		System.out.println(user.getRole());
		user.setPage(page);
		user.setRows(rows);
		List<UserModel> list=service.selectbyclass(user);
		Integer total=service.selectCount(user);
		//String total=Integer.parseUnsignedInt(service.selectAll(null).size());
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", total);
        jsonMap.put("rows", list);
        JSONObject json2=JSONObject.fromObject(jsonMap);
        System.out.println(json2.toString());
		return json2.toString() ;
	}
}
