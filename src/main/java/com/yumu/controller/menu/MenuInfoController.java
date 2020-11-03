package com.yumu.controller.menu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

}
