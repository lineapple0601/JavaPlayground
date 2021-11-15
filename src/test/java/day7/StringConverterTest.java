package day7;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringConverterTest {
	
	private StringConverter sc = new StringConverter();

	@BeforeAll
	static void init() {
//		System.out.println("@Before");
	}
	
	@BeforeEach
	void setUpEach() {
//		System.out.println("@BeforeEach");
	}
	
	@AfterEach
	void tearDownEach() {
//		System.out.println("@AfterEach");
	}
	
	@AfterAll
	static void down() {
//		System.out.println("@After");
	}
	
	@Test
	@DisplayName("仕様１：[a-z0-9]の文字を含めるパラメータ")
	void sanitizeName_Return_IfArgumentContainsTargetChars() {
		// org.opentest4j.AssertionFailedError: expected: <az09> but was: <az 09>
		// ? expected: "az 09" 
		// ? return value: "az09"
		Assertions.assertEquals(sc.sanitizeName("az09"), "az 09");
		
		// java.lang.AssertionError: 
		// Expected: is "az 09"
	    // but: was "az09"
		assertThat(sc.sanitizeName("az09"), is("az 09"));
	}
	
	@Test
	@DisplayName("仕様２：空文字を含めるパラメータ")
	void sanitizeName_ReturnHyphen_IfArgumentContainsWhitespace() {
		// org.opentest4j.AssertionFailedError: 空文字はハイフンに変わります ==> expected: <true> but was: <false>
//		assertTrue((sc.sanitizeName("   ").equals("---")), "空文字はハイフンに変わります");
//		assertTrue("空文字はハイフンに変わります", (sc.sanitizeName("   ") == "---"));
		
		// java.lang.AssertionError: 
		// Expected: is "- --"
	    // but: was "---"
		assertThat("空文字はハイフンに置換されてないです", sc.sanitizeName("   "), is("- --"));
	}
	
	@Test
	@DisplayName("大文字を含めるパラメータ")
	void sanitizeName_ReturnLowerCase_IfArgumentContainsUpperCase() {
		Assertions.assertEquals(sc.sanitizeName("ABC"), "abc");
	}
	
	@Test
	@DisplayName("[a-z0-9_-]意外の文字を含めるパラメータ")
	void sanitizeName_ReturnUnderbar_IfArgumentContainsOtherChars() {
		Assertions.assertEquals(sc.sanitizeName("]:?«,.+="), "________");
	}
	
	
}
