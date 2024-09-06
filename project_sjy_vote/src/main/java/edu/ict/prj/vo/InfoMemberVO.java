package edu.ict.prj.vo;

import java.sql.Timestamp;

public class InfoMemberVO {
	
	/*
    memb_code  NUMBER(5,0) PRIMARY KEY,
    memb_name VARCHAR2(100) NOT NULL,
    birth_date date,
    sex_g NUMBER(1,0) not null,
    tel_no VARCHAR2(100),
    juso VARCHAR2(200),
    grade NUMBER(1,0) not null,
    join_date date,
    retire_date date
    
    
	*/
	private int 	seqno;
	private int 	memb_code;
	private String  memb_name;
	private String 	birth_date;
	private int 	sex_g;
	private String  tel_no;
	private String  juso;
	private int 	grade;
	private String 	join_date;
	private String 	retire_date;

	public InfoMemberVO() {}
	
	public InfoMemberVO(int seqno,int memb_code,String  memb_name,String birth_date,int sex_g,String  tel_no,String  juso,int grade,String join_date,String retire_date ) {
		this.seqno 		= seqno;
		this.memb_code 	= memb_code;
		this.memb_name 	= memb_name;
		this.birth_date = birth_date;
		this.sex_g 		= sex_g;
		this.tel_no 	= tel_no;
		this.juso 		= juso;
		this.grade 		= grade;
		this.join_date 	= join_date;
		this.retire_date = retire_date;
	}

	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public int getMemb_code() {
		return memb_code;
	}

	public void setMemb_code(int memb_code) {
		this.memb_code = memb_code;
	}

	public String getMemb_name() {
		return memb_name;
	}

	public void setMemb_name(String memb_name) {
		this.memb_name = memb_name;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
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

	public String getJuso() {
		return juso;
	}

	public void setJuso(String juso) {
		this.juso = juso;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public String getRetire_date() {
		return retire_date;
	}

	public void setRetire_date(String retire_date) {
		this.retire_date = retire_date;
	}

	
	
	
	

}
