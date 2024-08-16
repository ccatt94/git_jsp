package edu.ict.shape;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
	public static int COUNT = 6;
	private Set<Integer> lottoSet;
	
	
	public Lotto() {
		lottoSet = new HashSet<>();
		
		while(lottoSet.size() < COUNT) {
			int num = (int) (Math.random()*45+1);
			lottoSet.add(num);
		}
	}

	public Set<Integer> getLottoSet(){
		return lottoSet;
	}
	
	public String getColor(int num) {
		String color = "black";
		
		if(num < 10) {
			color = "orange";
		}else if(num < 20) {
			color = "purple";
		}else if(num < 30) {
			color = "green";
		}else if(num < 40) {
			color = "blue";
		}	
		return color;
	}

}
