package edu.ict.star;

public class Star{
	private int num;
	
	public Star(int num) {
		this.num = num;
	}
	
	public void getDownStar() {
		
		for (int i = 1; i <= 5; i++) { 
			for (int j = 1; j <= i; j++) { 
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
		
}
