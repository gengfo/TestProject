package com.baobaotao.web;


import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;

//�ٱ�ע��Ϊһ��Spring MVC��Controller
@Controller
public class LoginController{
	
	@Autowired
	private UserService userService;
    
     //�ڸ�����/index.html������
	@RequestMapping(value = "/index.html")
	public String loginPage(){
		return "login";
	}
	
     //�۸�����/loginCheck.html������
	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request){
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));

		boolean isValidUser = 
			   userService.hasMatchUser(user.getUserName(),
					   user.getPassword());
		if (!isValidUser) {
			return new ModelAndView("login", "error", "�û������������");
		} else {
		   user = userService.findUserByUserName(user
					.getUserName());
			user.setLastIp(request.getLocalAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
			//ModelAndView mv = new ModelAndView("xStreamMarshallingView");
			//mv.addObject(user);
			//return mv;
		}
	}
}
