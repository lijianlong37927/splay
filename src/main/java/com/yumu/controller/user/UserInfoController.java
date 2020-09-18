package com.yumu.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yumu.controller.RequestPage;
import com.yumu.controller.Response;
import com.yumu.controller.ResponsePage;
import com.yumu.controller.user.req.DetailCheckReq;
import com.yumu.controller.user.req.DetailEditReq;
import com.yumu.controller.user.req.ListQueryReq;
import com.yumu.controller.user.resp.UserInfoListQueryResp;
import com.yumu.dto.UserInfo;
import com.yumu.service.UserInfoService;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/list/page")
	public String listPage() {
		return "/user/listPage";
	}

	@PostMapping("/list/query")
	@ResponseBody
	public ResponsePage<UserInfoListQueryResp> listQuery(@RequestBody RequestPage<ListQueryReq> page) {
		return userInfoService.listQuery(page);
	}

	@RequestMapping("/detail/check/page")
	public String detailPage(@RequestBody DetailCheckReq req, Model model) {
		UserInfo userInfo = userInfoService.getUserInfoById(req.getUserId());
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("showButton", "0");
		return "/user/detailPage";
	}

	@RequestMapping("/detail/edit/page")
	public String editPage(@RequestBody DetailCheckReq req, Model model) {
		UserInfo userInfo = userInfoService.getUserInfoById(req.getUserId());
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("showSubmitButton", "1");
		return "/user/detailPage";
	}

	@PostMapping("/detail/edit/submit")
	@ResponseBody
	public Response<Void> editSubmit(@RequestBody DetailEditReq req) {
		userInfoService.editSubmit(req);
		return Response.success();
	}

	@PostMapping("/detail/del/submit")
	@ResponseBody
	public Response<Void> delSubmit(@RequestBody DetailEditReq req) {
		userInfoService.delSubmit(req);
		return Response.success();
	}
}
