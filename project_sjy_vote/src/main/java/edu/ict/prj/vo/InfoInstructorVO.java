package edu.ict.prj.vo;

import java.sql.Timestamp;

public class InfoInstructorVO {

	/*
    ins_code  NUMBER(5,0) PRIMARY KEY,
    ins_name VARCHAR2(100) NOT NULL,
    empl_date date,
    retire_date date,
    qual_date date,
    sex_g NUMBER(1,0) not null,
    tel_no VARCHAR2(11)
	*/

	
	private int 		seqno;
	private int 		ins_code;
	private String  	ins_name;
	private String 		empl_date;
	private String 		retire_date;
	private String 		qual_date;
	private int 		sex_g;
	private String  	tel_no;
	private int 		lect_cnt;
	
	public InfoInstructorVO() {}
	
	public InfoInstructorVO(int seqno,int ins_code, String  ins_name, String empl_date, String retire_date, String qual_date, int sex_g, String  tel_no, int lect_cnt) {
		this.seqno 			= seqno;
		this.ins_code 		= ins_code;
	    this.ins_name 		= ins_name;
	    this.empl_date 		= empl_date;
	    this.retire_date 	= retire_date;
	    this.qual_date 		= qual_date;
	    this.sex_g 			= sex_g;
	    this.tel_no 		= tel_no;
	    this.lect_cnt 		= lect_cnt;
	}

	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
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

	public String getEmpl_date() {
		return empl_date;
	}

	public void setEmpl_date(String empl_date) {
		this.empl_date = empl_date;
	}

	public String getRetire_date() {
		return retire_date;
	}

	public void setRetire_date(String retire_date) {
		this.retire_date = retire_date;
	}

	public String getQual_date() {
		return qual_date;
	}

	public void setQual_date(String qual_date) {
		this.qual_date = qual_date;
	}

	public int getSex_g() {
		return sex_g;
	}

	public void setSex_g(int sex_g) {
		this.sex_g = sex_g;
	}

	public String getTel_no() {
		return tel_no;
	}

	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public int getLect_cnt() {
		return lect_cnt;
	}

	public void setLect_cnt(int lect_cnt) {
		this.lect_cnt = lect_cnt;
	}
	
	
	
}
