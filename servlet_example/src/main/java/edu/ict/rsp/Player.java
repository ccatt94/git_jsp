package edu.ict.rsp;

import java.util.HashSet;
import java.util.Set;

public class Player{
	
	private String rsp;
	private static final String[] rspArr = {"가위","바위","보"};
		
	public Player() {
		int num = (int) (Math.random()*3);
		rsp = rspArr[num];
		
	}
	
//	public String getRsp() {
//		
//	}
		
	
		
}
