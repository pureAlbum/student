package system.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import system.model.ClassAndTeacherModel;
import system.model.ClassModel;
import system.model.UserModel;
import system.service.ClassService;

@Controller
@RequestMapping("/class")
public class ClassAction {
	
	@Autowired
	public ClassService classService;
	
	@RequestMapping(value="/getname.do", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getname(String id) {
		System.out.println(id);
		ClassModel cm = classService.selectName(id);
		String str="班级："+cm.getName();
		return str;
	}
	
	@RequestMapping("/classinform.do")
	public String classinform(HttpServletRequest request) {
		UserModel user =(UserModel) request.getSession().getAttribute("user");
		String id = user.getClassCode();
		System.out.println(id);
		ClassAndTeacherModel cat= classService.classandteacher(id);
		request.setAttribute("classinf", cat);
		return "classinform";
	}
}
