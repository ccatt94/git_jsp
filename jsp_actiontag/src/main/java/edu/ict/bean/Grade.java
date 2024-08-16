package edu.ict.bean;

//Bean 객체
//일반 클래스 + 생성자 + getter/setter
public class Grade {
	private String name;
	private int kor, eng, math;
	
	public Grade() {}
	
	public Grade(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	public double getAvg() {
		return (kor + eng + math) / 3.0;
	}
	
	public String getGrade() {
		
		if(getAvg() >= 90) {
			return "수";
		}else if(getAvg() >= 80) {
			return "우";
		}else if(getAvg() >= 70) {
			return "미";
		}else if(getAvg() >= 60) {
			return "양";
		}else {
			return "가";
		}
	}
	
	
}
