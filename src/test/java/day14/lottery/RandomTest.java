package day14.lottery;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("serial")
public class RandomTest extends Random {
	
	private Iterator<Integer> iterator;
	
	public int nextIntCnt = 0;
	
	@Override
	public int nextInt(int bound) {
		nextIntCnt++;
		
		if (bound != 9) {
			throw new IllegalArgumentException("bound param is not 9");
		}
		return iterator.next().intValue();
	}
	
	@Test
	@DisplayName("")
	void test_getValueCase1() {
		
	}
}
