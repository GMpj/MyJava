package string;

import org.junit.Test;

public class MyStringUtils {
	@Test
	public static boolean isNumber(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
}
