package com.spring.application.register.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.application.register.model.Register;
import com.spring.application.register.service.RegisterService;
import com.spring.common.Page;
import com.spring.common.RequestAttribute;
import com.spring.common.data.LoadData;
import com.spring.common.data.model.Data;

@Controller
public class RegisterController {

	@Resource(name = "registerService")
	private RegisterService registerService;

	@RequestMapping("/register/main")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		setDefaultData(request);
		return "/pages/register/main";
	}

	@RequestMapping("/register/detail")
	public String detail(HttpServletRequest request,
			HttpServletResponse response) {
		Register register = new Register();
		String dbidkey = request.getParameter("dbidkey");
		if (StringUtils.isNotBlank(dbidkey)) {
			register = registerService.queryByDbidkey(dbidkey);
		} else {
			register.setDbidkey(UUID.randomUUID().toString());
		}
		String operate = request.getParameter("operate");
		if (StringUtils.isNotBlank(operate)) {
			request.setAttribute("operate", operate);
		} else {
			request.setAttribute("operate", "add");
		}
		request.setAttribute("register", register);

		setDefaultData(request);

		return "/pages/register/detail";
	}

	@ResponseBody
	@RequestMapping("/register/getRegisterList")
	public Page<Register> getRegisterList(HttpServletRequest request,
			HttpServletResponse response) {
		Page<Register> pager = new Page<Register>();
		Map<String, Object> param = new HashMap<String, Object>();
		setQueryParam(param, request);
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		if (StringUtils.isBlank(page)) {
			page = "1";
		}
		if (StringUtils.isBlank(rows)) {
			rows = "10";
		}

		List<Register> total = registerService.getRegisterList(param);
		param.put("start", (Integer.valueOf(page) - 1) * Integer.valueOf(rows));
		param.put("rows", Integer.valueOf(page) * Integer.valueOf(rows));
		List<Register> register = registerService.getRegisterList(param);

		if (register != null && register.size() > 0) {
			pager.setTotal(total.size());
			pager.setRows(register);
		} else {
			pager.setTotal(0);
			pager.setRows(new ArrayList<Register>());
		}

		return pager;

	}

	@ResponseBody
	@RequestMapping("/register/save")
	public Map<String, Object> save(HttpServletRequest request,
			HttpServletResponse response,
			@RequestAttribute(value = "register") final Register register) {
		Map<String, Object> rMap = new HashMap<String, Object>();
		String operate = request.getParameter("operate");
		if (StringUtils.isNotBlank(operate)) {
			try {
				if ("add".equals(operate)) {
					registerService.save(register);
					rMap.put("code", "success");
					rMap.put("message", "保存 成功");
				} else {
					registerService.update(register);
					rMap.put("code", "success");
					rMap.put("message", "修改 成功");
				}
			} catch (Exception e) {
				rMap.put("code", "false");
				rMap.put("message", "保存/修改 失败．<br/>" + e.getMessage());
				e.printStackTrace();
			}
		} else {
			rMap.put("code", "false");
			rMap.put("message", "保存/修改 失败．");
		}

		return rMap;
	}

	@ResponseBody
	@RequestMapping("/register/delete")
	public Map<String, Object> delete(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> rMap = new HashMap<String, Object>();
		String dbidkey = request.getParameter("dbidkey");
		if (StringUtils.isNotBlank(dbidkey)) {
			try {
				registerService.deleteByDbidkey(dbidkey);
				rMap.put("code", "success");
				rMap.put("message", "删除成功");
			} catch (Exception e) {
				rMap.put("code", "false");
				rMap.put("message", "删除失败．<br/>" + e.getMessage());
				e.printStackTrace();
			}
		} else {
			rMap.put("code", "false");
			rMap.put("message", "删除失败．");
		}

		return rMap;
	}

	private void setDefaultData(HttpServletRequest request) {
		Map<String, Data> data = LoadData.getData();
		request.setAttribute("selected", data.get("selected"));
		request.setAttribute("removed", data.get("removed"));
		request.setAttribute("hunthess", data.get("hunthess"));
	}

	private void setQueryParam(Map<String, Object> param,
			HttpServletRequest request) {
		String patientnum = request.getParameter("patientnum");
		if (StringUtils.isNotBlank(patientnum)) {
			param.put("patientnum", patientnum);
		}
		String hunthess = request.getParameter("hunthess");
		if (StringUtils.isNotBlank(hunthess)) {
			param.put("hunthess", hunthess);
		}
	}

}
