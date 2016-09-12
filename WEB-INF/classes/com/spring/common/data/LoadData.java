package com.spring.common.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;

import com.spring.common.data.model.Data;
import com.spring.common.data.model.DataColumn;
import com.spring.common.data.service.DataService;

@Repository
public class LoadData implements ApplicationListener<ApplicationEvent> {

	private static boolean isStart = false;
	
	private static Map<String, Data> data = new HashMap<String, Data>();

	@Resource(name = "dataService")
	private DataService dataService;

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		if (!isStart) {
			List<Data> list = dataService
					.getDataList(new HashMap<String, Object>());
			for (Data d: list){
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("datadbidkey", d.getDbidkey());
				List<DataColumn> dataColumn = dataService.getDataColumnList(param);
				d.setDataColumn(dataColumn);
				data.put(d.getCode(), d);
			}
			isStart = true;
		}
	}

	public static Map<String, Data> getData() {
		return data;
	}

	public static void setData(Map<String, Data> data) {
		LoadData.data = data;
	}
	
}
