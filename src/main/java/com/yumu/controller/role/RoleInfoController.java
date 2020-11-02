package com.yumu.controller.role;

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
import com.yumu.controller.role.vo.RoleInfoVo;
import com.yumu.service.RoleInfoService;

@Controller
@RequestMapping("/role")
public class RoleInfoController {

	@Autowired
	private RoleInfoService roleInfoService;

	@RequestMapping("/list")
	public String listPage() {
		return "/role/listPage";
	}

	@PostMapping("/list/query")
	@ResponseBody
	public ResponsePage<RoleInfoVo> listQuery(@RequestBody RequestPage<RoleInfoVo> page) {
		return roleInfoService.listQuery(page);
	}

	@RequestMapping("/detail/check")
	public ModelAndView detailPage(RoleInfoVo req) {
		RoleInfoVo roleInfoVo = roleInfoService.getRoleInfoById(req.getRoleId());
		ModelAndView mv = new ModelAndView("/role/detailPage");
		mv.addObject("roleInfo", roleInfoVo);
		mv.addObject("editFlag", "0");
		return mv;
	}

	@RequestMapping("/detail/edit")
	public ModelAndView editPage(RoleInfoVo req) {
		RoleInfoVo roleInfoVo = roleInfoService.getRoleInfoById(req.getRoleId());
		ModelAndView mv = new ModelAndView("/role/detailPage");
		mv.addObject("roleInfo", roleInfoVo);
		mv.addObject("editFlag", "1");
		return mv;
	}

	@PostMapping("/detail/edit/submit")
	@ResponseBody
	public Response<Void> editSubmit(@RequestBody RoleInfoVo req) {
		roleInfoService.editSubmit(req);
		return Response.success();
	}

	@PostMapping("/detail/del/submit")
	@ResponseBody
	public Response<Void> delSubmit(@RequestBody RoleInfoVo req) {
		roleInfoService.delSubmit(req);
		return Response.success();
	}
}
