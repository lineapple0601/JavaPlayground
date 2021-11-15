package day14.lottery;

public class MockScratch implements IScratch {
	
	private int[][] sheet;
	
	public MockScratch(int[][] sheet) {
		this.sheet = sheet;
	}
	
	public int getValue(int row, int col) {
		return sheet[row][col];
	}
	
}
