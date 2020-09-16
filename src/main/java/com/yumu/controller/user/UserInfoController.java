package com.yumu.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yumu.controller.RequestPage;
import com.yumu.controller.Response;
import com.yumu.controller.ResponsePage;
import com.yumu.controller.user.req.UserInfoEditReq;
import com.yumu.controller.user.req.UserInfoListReq;
import com.yumu.controller.user.resp.UserInfoListResp;
import com.yumu.service.UserInfoService;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/listPage")
	public String listPage() {
		return "/user/listPage";
	}

	@PostMapping("/list")
	@ResponseBody
	public ResponsePage<UserInfoListResp> list(@RequestBody RequestPage<UserInfoListReq> page) {
		return userInfoService.list(page);
	}

	@RequestMapping("/detailPage")
	public String detailPage() {
		return "/user/detailPage";
	}

	@PostMapping("/edit")
	@ResponseBody
	public Response<Void> list(@RequestBody UserInfoEditReq req) {
		userInfoService.edit(req);
		return Response.success();
	}
}
