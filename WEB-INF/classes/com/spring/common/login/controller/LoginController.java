package com.spring.common.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.spring.common.login.model.Menu;
import com.spring.common.login.model.User;
import com.spring.common.login.service.MenuService;
import com.spring.common.login.service.UserService;

@Controller
public class LoginController {

	@Resource(name = "menuService")
	private MenuService menuService;

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String result = "{\"user\":\"" + username + "\",\"login\":\"true\"}";
		if (StringUtils.isNotBlank(username)) {
			List<User> user = userService.getUserByUserName(username);
			if (user != null && user.size() > 0
					&& password.equals(user.get(0).getPassword())) {
				result = "{\"user\":\"" + username + "\",\"login\":\"true\"}";
				request.getSession().setAttribute("username", username);
				WebUtils.setSessionAttribute(request, "username", username);
				String ctp = request.getContextPath();
				request.getSession().setAttribute("ctp", ctp);
			} else {
				result = "{\"user\":\"" + username + "\",\"login\":\"false\"}";
			}
		}

		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Charset", "UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "pages/login";
	}

	@RequestMapping("/main")
	public String mainPage(HttpServletRequest request,
			HttpServletResponse response) {

		// String username =
		// request.getSession().getAttribute("username").toString();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("parentDbIdKey", "0");
		List<Menu> menu = menuService.getMenuListByParam(param);
		if (menu != null && menu.size() > 0) {
			for (Menu m : menu) {
				param = new HashMap<String, Object>();
				param.put("parentDbIdKey", m.getDbidkey());
				List<Menu> children = menuService.getMenuListByParam(param);
				m.setChildren(children);
			}
		}
		request.setAttribute("menu", menu);

		return "pages/main";
	}

	@ResponseBody
	@RequestMapping("/menu")
	public List<Menu> menu(HttpServletRequest request,
			HttpServletResponse response) {

		// String username =
		// request.getSession().getAttribute("username").toString();
		List<Menu> menu = menuService.getMenuList();

		return menu;
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().setAttribute("username", null);
		WebUtils.setSessionAttribute(request, "username", null);
		return "pages/login";
	}
}