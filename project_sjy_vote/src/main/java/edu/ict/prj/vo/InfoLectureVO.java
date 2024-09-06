package edu.ict.prj.vo;

import java.sql.Timestamp;

public class InfoLectureVO {
	
	/*
    lecture_code  NUMBER(5,0) PRIMARY KEY,
    lecture_name VARCHAR2(100) NOT NULL,
    ins_code  NUMBER(5,0) not null,
    mozip_st_dt date,
    mozip_end_dt date,
    lect_st_dt date,
    lect_end_dt date,
    lect_fee NUMBER(12,0) not null,
    lect_grade NUMBER(1,0) not null,
    lect_place VARCHAR2(100)
	 */
	
	private int 		seqno;
	private int 		lecture_code;
	private String  	lecture_name;
	private int 		ins_code;
	private String 		ins_name;
	private String 		mozip_st_dt;
	private String 		mozip_end_dt;
	private String 		lect_st_dt;
	private String 		lect_end_dt;
	private String 		lect_fee;
	private int 		lect_grade;
	private String 		lect_place;
	private int 		reqcnt;

	public InfoLectureVO() {}
	
	public InfoLectureVO(int seqno,int lecture_code,String  lecture_name,int ins_code,String ins_name,String mozip_st_dt,String mozip_end_dt,String lect_st_dt,String lect_end_dt,String lect_fee,int lect_grade,String lect_place,int reqcnt  ) {
		this.seqno 			= seqno;
		this.lecture_code 	= lecture_code;
		this.lecture_name 	= lecture_name;
		this.ins_code 		= ins_code;
		this.ins_name 		= ins_name;
		this.mozip_st_dt 	= mozip_st_dt;
		this.mozip_end_dt 	= mozip_end_dt;
		this.lect_st_dt 	= lect_st_dt;
		this.lect_end_dt 	= lect_end_dt;
		this.lect_fee 		= lect_fee;
		this.lect_grade 	= lect_grade;
		this.lect_place 	= lect_place;
		this.reqcnt 		= reqcnt;
	}

	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public int getLecture_code() {
		return lecture_code;
	}
	public void setLecture_code(int lecture_code) {
		this.lecture_code = lecture_code;
	}

	public String getLecture_name() {
		return lecture_name;
	}

	public void setLecture_name(String lecture_name) {
		this.lecture_name = lecture_name;
	}

	public int getIns_code() {
		return ins_code;
	}
	public void setIns_code(int ins_code) {
		this.ins_code = ins_code;
	}

	public String getIns_name() {
		return ins_name;
	}
	public void setIns_name(String ins_name) {
		this.ins_name = ins_name;
	}
	
	public String getMozip_st_dt() {
		return mozip_st_dt;
	}

	public void setMozip_st_dt(String mozip_st_dt) {
		this.mozip_st_dt = mozip_st_dt;
	}

	public String getMozip_end_dt() {
		return mozip_end_dt;
	}

	public void setMozip_end_dt(String mozip_end_dt) {
		this.mozip_end_dt = mozip_end_dt;
	}

	public String getLect_st_dt() {
		return lect_st_dt;
	}

	public void setLect_st_dt(String lect_st_dt) {
		this.lect_st_dt = lect_st_dt;
	}

	public String getLect_end_dt() {
		return lect_end_dt;
	}

	public void setLect_end_dt(String lect_end_dt) {
		this.lect_end_dt = lect_end_dt;
	}

	public String getLect_fee() {
		return lect_fee;
	}

	public void setLect_fee(String lect_fee) {
		this.lect_fee = lect_fee;
	}

	public int getLect_grade() {
		return lect_grade;
	}
	public void setLect_grade(int lect_grade) {
		this.lect_grade = lect_grade;
	}

	public String getLect_place() {
		return lect_place;
	}
	public void setLect_place(String lect_place) {
		this.lect_place = lect_place;
	}

	public int getReqcnt() {
		return reqcnt;
	}
	public void setReqcnt(int reqcnt) {
		this.reqcnt = reqcnt;
	}
	
	
}
