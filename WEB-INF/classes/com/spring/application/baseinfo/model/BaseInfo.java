package com.spring.application.baseinfo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring.common.model.Entity;

public class BaseInfo extends Entity {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;

	private String sex;

	private String nation;

	private String idCard;

	private Integer high;

	private Integer weight;

	private String hospitalnum;

	private String recordnum;

	private String address;

	private String patientnum;

	private String tel;

	private String phone;

	private String mail;

	private Integer agreecontact;

	private String othername;

	private String otheraddress;

	private String othertel;

	private String otherphone;

	private String othermail;

	private String relation;

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getHigh() {
		return high;
	}

	public void setHigh(Integer high) {
		this.high = high;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getHospitalnum() {
		return hospitalnum;
	}

	public void setHospitalnum(String hospitalnum) {
		this.hospitalnum = hospitalnum;
	}

	public String getRecordnum() {
		return recordnum;
	}

	public void setRecordnum(String recordnum) {
		this.recordnum = recordnum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPatientnum() {
		return patientnum;
	}

	public void setPatientnum(String patientnum) {
		this.patientnum = patientnum;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getAgreecontact() {
		return agreecontact;
	}

	public void setAgreecontact(Integer agreecontact) {
		this.agreecontact = agreecontact;
	}

	public String getOthername() {
		return othername;
	}

	public void setOthername(String othername) {
		this.othername = othername;
	}

	public String getOtheraddress() {
		return otheraddress;
	}

	public void setOtheraddress(String otheraddress) {
		this.otheraddress = otheraddress;
	}

	public String getOthertel() {
		return othertel;
	}

	public void setOthertel(String othertel) {
		this.othertel = othertel;
	}

	public String getOtherphone() {
		return otherphone;
	}

	public void setOtherphone(String otherphone) {
		this.otherphone = otherphone;
	}

	public String getOthermail() {
		return othermail;
	}

	public void setOthermail(String othermail) {
		this.othermail = othermail;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

}
