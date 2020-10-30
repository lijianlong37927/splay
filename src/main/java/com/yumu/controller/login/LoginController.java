package com.yumu.controller.login;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yumu.context.LocalContext;
import com.yumu.controller.Response;
import com.yumu.controller.login.vo.LoginMenuListVo;
import com.yumu.controller.login.vo.LoginVo;
import com.yumu.exception.ExceptionConst;
import com.yumu.exception.ServiceException;
import com.yumu.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	@ResponseBody
	public Response<Void> login(@RequestBody LoginVo req) {
		loginService.login(req.getUserId(), req.getPassword());
		return Response.success();
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/menuList")
	@ResponseBody
	public Response<List<LoginMenuListVo>> menuList(HttpServletRequest request) {
		return Response.success(loginService.menuList(LocalContext.getRequestContext().getUserId()));
	}

	@RequestMapping("/errorMsg")
	public void errorMsg(HttpServletRequest request) {
		ServiceException.throwException((ExceptionConst) request.getAttribute("ERROR_MSG_CONST"));
	}
}
