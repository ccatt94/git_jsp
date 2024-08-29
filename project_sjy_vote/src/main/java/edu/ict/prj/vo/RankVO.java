package edu.ict.prj.vo;

public class RankVO {
	private String m_no;
	private String m_name;
	private String v_count;
	
	public RankVO() {}

	public RankVO(String m_no, String m_name, String v_count) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.v_count = v_count;
	}

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getV_count() {
		return v_count;
	}

	public void setV_count(String v_count) {
		this.v_count = v_count;
	}
	
	

}
