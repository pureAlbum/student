package system.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import system.model.RoleModel;
import system.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleAction {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/getname.do", produces="text/html;charset=UTF-8" )
	@ResponseBody
	public String getRloeName(String role) {
		System.out.println(role);
		RoleModel rm = roleService.selectRole(role);
		//return "aaaa";
		System.out.println(rm.getRoleName());
		String str="身份："+rm.getRoleName();
		return str;
	}
}
