package edu.ict.shape;

public class Circle {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public void setRadius(int r) {
		radius = r;
	}

	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return radius * radius * Math.PI;
	}

}
