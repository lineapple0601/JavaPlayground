package day14.lottery;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * ハンズオン: IScratchをMockしてWinCalculatorをテストしよう
 */
class WinCalculatorTest {
	
	private WinCalculator winCalculator = new WinCalculator();
	
	private static final int[][] CASE_1_SHEET = {
		{1, 1, 1},
		{2, 3, 4},
		{5, 6, 7}
	};
	
	private static final int[][] CASE_2_SHEET = {
		{1, 2, 3},
		{5, 6, 7},
		{4, 4, 4}
	};
	
	private static final int[][] CASE_3_SHEET = {
		{1, 1, 1},
		{1, 1, 1},
		{1, 1, 1}
	};
	
	private static final int[][] CASE_4_SHEET = {
		{9, 1, 9},
		{1, 9, 1},
		{9, 1, 9}
	};
	
	private static final int[][] CASE_5_SHEET = {
		{9, 1, 9},
		{9, 2, 9},
		{9, 3, 9}
	};
	
	private static final int[][] CASE_6_SHEET = {
		{2, 1, 2},
		{1, 1, 1},
		{4, 1, 4}
	};
	
	private static final int[][] CASE_7_SHEET = {
		{1, 1, 1},
		{1, 2, 1},
		{1, 1, 1}
	};

	@Test
	@DisplayName("1行目が全て1の時は10を返す")
	void checkWithCase1() {
		IScratch iscratch = new MockScratch(CASE_1_SHEET);
		assertThat(winCalculator.check(iscratch), is(10L));
	}
	
	@Test
	@DisplayName("3行目が全て4の時は40を返す")
	void checkWithCase2() {
		IScratch iscratch = new MockScratch(CASE_2_SHEET);
		assertThat(winCalculator.check(iscratch), is(40L));
	}
	
	@Test
	@DisplayName("全ての値が1の場合、1億を返す")
	void checkWithCase3() {
		IScratch iscratch = new MockScratch(CASE_3_SHEET);
		assertThat(winCalculator.check(iscratch), is(100000000L));
	}
	
	@Test
	@DisplayName("斜めビンゴで9の値が当たる場合、8100を返す")
	void checkWithCase4() {
		IScratch iscratch = new MockScratch(CASE_4_SHEET);
		assertThat(winCalculator.check(iscratch), is(8100L));
	}
	
	@Test
	@DisplayName("1列目と3列目のビンゴで9が当たる場合、8100を返す")
	void checkWithCase5() {
		IScratch iscratch = new MockScratch(CASE_5_SHEET);
		assertThat(winCalculator.check(iscratch), is(8100L));
	}
	
	@Test
	@DisplayName("2列目と2行目のビンゴで1が当たる場合、100を返す")
	void checkWithCase6() {
		IScratch iscratch = new MockScratch(CASE_6_SHEET);
		assertThat(winCalculator.check(iscratch), is(100L));
	}
	
	@Test
	@DisplayName("1・3行目と1・3列目のビンゴで9が当たる場合、10000を返す")
	void checkWithCase7() {
		IScratch iscratch = new MockScratch(CASE_7_SHEET);
		assertThat(winCalculator.check(iscratch), is(10000L));
	}
}
