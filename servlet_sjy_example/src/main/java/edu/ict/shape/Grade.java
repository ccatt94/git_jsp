package edu.ict.shape;

public class Grade {

	private String name;
	private double kor, eng, math, area;

	public Grade(String name, double kor, double eng, double math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String getName() {
		return name;
	}

	public double getAvg() {
		area = (kor + eng + math) / 3.0;
		return area;
	}

	public String getGrade() {

		if (area >= 90) {
			return "��";
		} else if (area >= 80) {
			return "��";
		} else if (area >= 70) {
			return "��";
		} else if (area >= 60) {
			return "��";
		} else {
			return "��";
		}

	}

}
