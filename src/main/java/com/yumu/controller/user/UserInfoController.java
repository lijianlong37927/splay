package com.yumu.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.yumu.controller.RequestPage;
import com.yumu.controller.Response;
import com.yumu.controller.ResponsePage;
import com.yumu.controller.user.vo.UserInfoVo;
import com.yumu.service.UserInfoService;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/list")
	public String listPage() {
		return "/user/userList";
	}

	@PostMapping("/list/query")
	@ResponseBody
	public ResponsePage<UserInfoVo> listQuery(@RequestBody RequestPage<UserInfoVo> page) {
		return userInfoService.listQuery(page);
	}

	@RequestMapping("/detail/new")
	public ModelAndView newPage(UserInfoVo req) {
		ModelAndView mv = new ModelAndView("/user/userNew");
		mv.addObject("userInfo", userInfoService.newPage());
		return mv;
	}

	@RequestMapping("/detail/new/submit")
	public Response<Void> newSubmit(UserInfoVo req) {
		userInfoService.newSubmit(req);
		return Response.success();
	}

	@RequestMapping("/detail/check")
	public ModelAndView detailPage(UserInfoVo req) {
		UserInfoVo userInfoVo = userInfoService.getUserInfoById(req.getUserId());
		ModelAndView mv = new ModelAndView("/user/userDetail");
		mv.addObject("userInfo", userInfoVo);
		mv.addObject("editFlag", "0");
		return mv;
	}

	@RequestMapping("/detail/edit")
	public ModelAndView editPage(UserInfoVo req) {
		UserInfoVo userInfoVo = userInfoService.getUserInfoById(req.getUserId());
		ModelAndView mv = new ModelAndView("/user/userDetail");
		mv.addObject("userInfo", userInfoVo);
		mv.addObject("editFlag", "1");
		return mv;
	}

	@PostMapping("/detail/edit/submit")
	@ResponseBody
	public Response<Void> editSubmit(@RequestBody UserInfoVo req) {
		userInfoService.editSubmit(req);
		return Response.success();
	}

	@PostMapping("/list/del/submit")
	@ResponseBody
	public Response<Void> delSubmit(@RequestBody UserInfoVo req) {
		userInfoService.delSubmit(req);
		return Response.success();
	}
}
