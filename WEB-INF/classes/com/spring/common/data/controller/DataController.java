package com.spring.common.data.controller;

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

import com.spring.common.Page;
import com.spring.common.RequestAttribute;
import com.spring.common.data.model.Data;
import com.spring.common.data.model.DataColumn;
import com.spring.common.data.service.DataService;

@Controller
public class DataController {

	@Resource(name = "dataService")
	private DataService dataService;

	@RequestMapping("/data/main")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "/pages/data/main";
	}

	@RequestMapping("/data/detail")
	public String detail(HttpServletRequest request, HttpServletResponse response) {
		Data data = new Data();
		String dbidkey = request.getParameter("dbidkey");
		if (StringUtils.isNotBlank(dbidkey)){
			data = dataService.queryByDbidkey(dbidkey);
		} else {
			data.setDbidkey(UUID.randomUUID().toString());
		}
		String operate = request.getParameter("operate");
		if (StringUtils.isNotBlank(operate)){
			request.setAttribute("operate", operate);
		} else {
			request.setAttribute("operate", "add");
		}
		request.setAttribute("data", data);
		
		return "/pages/data/detail";
	}

	@RequestMapping("/data/datacolumn")
	public String datacolumn(HttpServletRequest request, HttpServletResponse response) {
		String dbidkey = request.getParameter("dbidkey");
		request.setAttribute("dbidkey", dbidkey);
		return "/pages/data/datacolumn";
	}

	@RequestMapping("/data/datacolumndetail")
	public String dataColumnDetail(HttpServletRequest request, HttpServletResponse response) {
		DataColumn dataColumn = new DataColumn();
		String dbidkey = request.getParameter("dbidkey");
		String dataDbidkey = request.getParameter("dataDbidkey");
		if (StringUtils.isNotBlank(dbidkey)){
			dataColumn = dataService.queryDataColumnByDbidkey(dbidkey);
		} else {
			dataColumn.setDbidkey(UUID.randomUUID().toString());
			dataColumn.setDatadbidkey(dataDbidkey);
		}
		String operate = request.getParameter("operate");
		if (StringUtils.isNotBlank(operate)){
			request.setAttribute("operate", operate);
		} else {
			request.setAttribute("operate", "add");
		}
		request.setAttribute("dataColumn", dataColumn);
		return "/pages/data/datacolumndetail";
	}

	@ResponseBody
	@RequestMapping("/data/getDataList")
	public Page<Data> getDataList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page<Data> pager = new Page<Data>();
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
		
		List<Data> total = dataService.getDataList(param);
		param.put("start",(Integer.valueOf(page) - 1) * Integer.valueOf(rows));
		param.put("rows", Integer.valueOf(page) * Integer.valueOf(rows));
		List<Data> data = dataService.getDataList(param);
		
		if (data != null && data.size() > 0){
			pager.setTotal(total.size());
			pager.setRows(data);
		} else {
			pager.setTotal(0);
			pager.setRows(new ArrayList<Data>());
		}
		
		return pager;

	}

	@ResponseBody
	@RequestMapping("/data/getDataColumnList")
	public Page<DataColumn> getDataColumnList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page<DataColumn> pager = new Page<DataColumn>();
		Map<String, Object> param = new HashMap<String, Object>();
		
		//setQueryParam(param, request);
		String datadbidkey = request.getParameter("datadbidkey");
		param.put("datadbidkey", datadbidkey);
		
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		if (StringUtils.isBlank(page)){
			page = "1";
		}
		if (StringUtils.isBlank(rows)){
			rows = "10";
		}
		
		List<DataColumn> total = dataService.getDataColumnList(param);
		param.put("start",(Integer.valueOf(page) - 1) * Integer.valueOf(rows));
		param.put("rows", Integer.valueOf(page) * Integer.valueOf(rows));
		List<DataColumn> dataColumn = dataService.getDataColumnList(param);
		
		if (dataColumn != null && dataColumn.size() > 0){
			pager.setTotal(total.size());
			pager.setRows(dataColumn);
		} else {
			pager.setTotal(0);
			pager.setRows(new ArrayList<DataColumn>());
		}
		
		return pager;

	}
	
	@ResponseBody
	@RequestMapping("/data/save")
	public Map<String, Object> save(HttpServletRequest request,
			HttpServletResponse response, @RequestAttribute(value="data") final Data data){
		Map<String, Object> rMap = new HashMap<String, Object>();
		String operate = request.getParameter("operate");
		if (StringUtils.isNotBlank(operate)){
			try {
				if ("add".equals(operate)){
					dataService.save(data);
					rMap.put("code", "success");
					rMap.put("message", "保存 成功");
				} else {
					dataService.update(data);
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
	@RequestMapping("/data/saveColumn")
	public Map<String, Object> saveColumn(HttpServletRequest request,
			HttpServletResponse response, @RequestAttribute(value="dataColumn") final DataColumn dataColumn){
		Map<String, Object> rMap = new HashMap<String, Object>();
		String operate = request.getParameter("operate");
		if (StringUtils.isNotBlank(operate)){
			try {
				if ("add".equals(operate)){
					dataService.saveColumn(dataColumn);
					rMap.put("code", "success");
					rMap.put("message", "保存 成功");
				} else {
					dataService.updateColumn(dataColumn);
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
	@RequestMapping("/data/delete")
	public Map<String, Object> delete(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> rMap = new HashMap<String, Object>();
		String dbidkey = request.getParameter("dbidkey");
		if (StringUtils.isNotBlank(dbidkey)){
			try {
				dataService.deleteByDbidkey(dbidkey);
				dataService.deleteColumnByDataDbidkey(dbidkey);
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

	@ResponseBody
	@RequestMapping("/data/deleteColumn")
	public Map<String, Object> deleteColumn(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> rMap = new HashMap<String, Object>();
		String dbidkey = request.getParameter("dbidkey");
		if (StringUtils.isNotBlank(dbidkey)){
			try {
				dataService.deleteColumnByDbidkey(dbidkey);
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
	}

}
