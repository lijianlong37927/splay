package com.yumu.controller.menu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.yumu.controller.Response;
import com.yumu.controller.menu.vo.MenuInfoVo;
import com.yumu.service.MenuInfoService;

@Controller
@RequestMapping("/menu")
public class MenuInfoController {

	@Autowired
	private MenuInfoService menuInfoService;

	@RequestMapping("/list")
	public String listPage() {
		return "/menu/menuList";
	}

	@PostMapping("/list/query")
	@ResponseBody
	public Response<List<MenuInfoVo>> listQuery() {
		return Response.success(menuInfoService.listQuery());
	}

	@RequestMapping("/detail/new/submit")
	@ResponseBody
	public Response<List<MenuInfoVo>> newSubmit(@RequestBody MenuInfoVo req) {
		return Response.success(menuInfoService.newSubmit(req));
	}

	@RequestMapping("/detail/edit")
	public ModelAndView editPage(MenuInfoVo req) {
		MenuInfoVo menuInfoVo = menuInfoService.getMenuInfoById(req.getId());
		ModelAndView mv = new ModelAndView("/menu/menuDetail");
		mv.addObject("menuInfoVo", menuInfoVo);
		return mv;
	}

	@PostMapping("/detail/edit/submit")
	@ResponseBody
	public Response<Void> editSubmit(@RequestBody MenuInfoVo req) {
		menuInfoService.editSubmit(req);
		return Response.success();
	}

	@PostMapping("/detail/del/submit")
	@ResponseBody
	public Response<Void> delSubmit(@RequestBody MenuInfoVo req) {
		menuInfoService.delSubmit(req);
		return Response.success();
	}
}
