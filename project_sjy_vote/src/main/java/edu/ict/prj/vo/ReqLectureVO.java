package edu.ict.prj.vo;

import java.sql.Timestamp;

public class ReqLectureVO {
	
	/*
    lecture_code  NUMBER(5,0) not null,
    seq_no  NUMBER(10,0) not null,
    memb_code  NUMBER(5,0) not null,
    lect_req_dt date,
    lect_cncl_dt  date,
    lect_exit_dt date,
    lect_fee NUMBER(12,0) not null,
    lect_repay_fee NUMBER(12,0) not null
	 */
	private int lecture_code;
	private int seq_no;
	private int memb_code;
	private Timestamp lect_req_dt;
	private Timestamp lect_cncl_dt;
	private Timestamp lect_exit_dt;
	private int lect_fee;
	private int lect_repay_fee;

	public ReqLectureVO() {}
	
	public ReqLectureVO(int lecture_code,int seq_no,int memb_code, Timestamp lect_req_dt, Timestamp lect_cncl_dt,Timestamp lect_exit_dt,int lect_fee,int lect_repay_fee) {
		this.lecture_code 	= lecture_code;
		this.seq_no 		= seq_no;
		this.memb_code 		= memb_code;
		this.lect_req_dt 	= lect_req_dt;
		this.lect_cncl_dt 	= lect_cncl_dt;
		this.lect_exit_dt 	= lect_exit_dt;
		this.lect_fee 		= lect_fee;
		this.lect_repay_fee = lect_repay_fee;
	}

	public int getLecture_code() {
		return lecture_code;
	}

	public void setLecture_code(int lecture_code) {
		this.lecture_code = lecture_code;
	}

	public int getSeq_no() {
		return seq_no;
	}

	public void setSeq_no(int seq_no) {
		this.seq_no = seq_no;
	}

	public int getMemb_code() {
		return memb_code;
	}

	public void setMemb_code(int memb_code) {
		this.memb_code = memb_code;
	}

	public Timestamp getLect_req_dt() {
		return lect_req_dt;
	}

	public void setLect_req_dt(Timestamp lect_req_dt) {
		this.lect_req_dt = lect_req_dt;
	}

	public Timestamp getLect_cncl_dt() {
		return lect_cncl_dt;
	}

	public void setLect_cncl_dt(Timestamp lect_cncl_dt) {
		this.lect_cncl_dt = lect_cncl_dt;
	}

	public Timestamp getLect_exit_dt() {
		return lect_exit_dt;
	}

	public void setLect_exit_dt(Timestamp lect_exit_dt) {
		this.lect_exit_dt = lect_exit_dt;
	}

	public int getLect_fee() {
		return lect_fee;
	}

	public void setLect_fee(int lect_fee) {
		this.lect_fee = lect_fee;
	}

	public int getLect_repay_fee() {
		return lect_repay_fee;
	}

	public void setLect_repay_fee(int lect_repay_fee) {
		this.lect_repay_fee = lect_repay_fee;
	}
	

	
}
