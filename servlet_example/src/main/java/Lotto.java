import java.util.HashSet;
import java.util.Set;

public class Lotto{
	
	private final int LOTTO = 6;
	private int[] lottoArr = new int[LOTTO];
	
	public void Lotto() {
		
	}
	
	public void getLottoNum() {
		
		Set<Integer> lottoSet = new HashSet<>();
		
		while(lottoSet.size() < LOTTO) {
			
			int num = (int) (Math.random()*45+1);
			lottoSet.add(num);
			

			
		}
		
		
		
		
		
	}
	
	
	
		
		
		
}
