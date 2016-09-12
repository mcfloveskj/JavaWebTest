package com.spring.application.register.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring.common.model.Entity;

public class Register extends Entity {

	private String patientnum;

	private String selected;

	private String removed;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date sahbaddate;

	private Integer hunthess;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date informdate;

	private Integer islive;

	private String studenta;

	private String studentb;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date signdate;

	public String getPatientnum() {
		return patientnum;
	}

	public void setPatientnum(String patientnum) {
		this.patientnum = patientnum;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String getRemoved() {
		return removed;
	}

	public void setRemoved(String removed) {
		this.removed = removed;
	}

	public Date getSahbaddate() {
		return sahbaddate;
	}

	public void setSahbaddate(Date sahbaddate) {
		this.sahbaddate = sahbaddate;
	}

	public Integer getHunthess() {
		return hunthess;
	}

	public void setHunthess(Integer hunthess) {
		this.hunthess = hunthess;
	}

	public Date getInformdate() {
		return informdate;
	}

	public void setInformdate(Date informdate) {
		this.informdate = informdate;
	}

	public Integer getIslive() {
		return islive;
	}

	public void setIslive(Integer islive) {
		this.islive = islive;
	}

	public String getStudenta() {
		return studenta;
	}

	public void setStudenta(String studenta) {
		this.studenta = studenta;
	}

	public String getStudentb() {
		return studentb;
	}

	public void setStudentb(String studentb) {
		this.studentb = studentb;
	}

	public Date getSigndate() {
		return signdate;
	}

	public void setSigndate(Date signdate) {
		this.signdate = signdate;
	}
}
