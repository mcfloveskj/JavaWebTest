package com.spring.application.baseinfo.controller;

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

import com.spring.application.baseinfo.model.BaseInfo;
import com.spring.application.baseinfo.service.BaseInfoService;
import com.spring.common.Page;
import com.spring.common.RequestAttribute;

@Controller
public class BaseInfoController {

	@Resource(name = "baseInfoService")
	private BaseInfoService baseInfoService;

	@RequestMapping("/baseinfo/main")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "/pages/baseinfo/main";
	}

	@RequestMapping("/baseinfo/detail")
	public String detail(HttpServletRequest request, HttpServletResponse response) {
		BaseInfo baseInfo = new BaseInfo();
		String dbidkey = request.getParameter("dbidkey");
		if (StringUtils.isNotBlank(dbidkey)){
			baseInfo = baseInfoService.queryByDbidkey(dbidkey);
		} else {
			baseInfo.setDbidkey(UUID.randomUUID().toString());
		}
		String operate = request.getParameter("operate");
		if (StringUtils.isNotBlank(operate)){
			request.setAttribute("operate", operate);
		} else {
			request.setAttribute("operate", "add");
		}
		request.setAttribute("baseInfo", baseInfo);
		
		return "/pages/baseinfo/detail";
	}

	@ResponseBody
	@RequestMapping("/baseinfo/getPatientList")
	public Page<BaseInfo> getPatientList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page<BaseInfo> pager = new Page<BaseInfo>();
		Map<String, Object> param = new HashMap<String, Object>();
		
		setQueryParam(param, request);
		
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		if (StringUtils.isBlank(page)){
			page = "1";
		}
		if (StringUtils.isBlank(rows)){
			rows = "10";
		}
		
		List<BaseInfo> total = baseInfoService.getPatientList(param);
		param.put("start",(Integer.valueOf(page) - 1) * Integer.valueOf(rows));
		param.put("rows", Integer.valueOf(page) * Integer.valueOf(rows));
		List<BaseInfo> baseInfo = baseInfoService.getPatientList(param);
		
		if (baseInfo != null && baseInfo.size() > 0){
			pager.setTotal(total.size());
			pager.setRows(baseInfo);
		} else {
			pager.setTotal(0);
			pager.setRows(new ArrayList<BaseInfo>());
		}
		
		return pager;

	}
	
	@ResponseBody
	@RequestMapping("/baseinfo/save")
	public Map<String, Object> save(HttpServletRequest request,
			HttpServletResponse response, @RequestAttribute(value="baseInfo") final BaseInfo baseInfo){
		Map<String, Object> rMap = new HashMap<String, Object>();
		String operate = request.getParameter("operate");
		if (StringUtils.isNotBlank(operate)){
			try {
				if ("add".equals(operate)){
					baseInfoService.save(baseInfo);
					rMap.put("code", "success");
					rMap.put("message", "保存 成功");
				} else {
					baseInfoService.update(baseInfo);
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
	@RequestMapping("/baseinfo/delete")
	public Map<String, Object> delete(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> rMap = new HashMap<String, Object>();
		String dbidkey = request.getParameter("dbidkey");
		if (StringUtils.isNotBlank(dbidkey)){
			try {
				baseInfoService.deleteByDbidkey(dbidkey);
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
	
	public void setQueryParam(Map<String, Object> rMap, HttpServletRequest request) throws Exception{
		String patientnum = request.getParameter("patientnum");
		if (StringUtils.isNotBlank(patientnum)){
			rMap.put("patientnum", patientnum);
		}
		String name = request.getParameter("name");
		if (StringUtils.isNotBlank(name)){
			rMap.put("name", name);
		}
		String sex = request.getParameter("sex");
		if (StringUtils.isNotBlank(sex)){
			rMap.put("sex", sex);
		}
	}

}
