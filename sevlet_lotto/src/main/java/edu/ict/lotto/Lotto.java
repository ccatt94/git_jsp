package edu.ict.lotto;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
	
	public static final int COUNT = 6;
	public Set<Integer> lottoSet;
	
	
	public Lotto(){
		
		lottoSet = new HashSet<>();
		
		while(lottoSet.size() < COUNT) {
			int num = (int)(Math.random()*45+1);
			lottoSet.add(num);
		}
	
	}
	
	public Set<Integer> getLottoSet(){
		return lottoSet;
	}


	
}
