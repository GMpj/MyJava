package Test;

import org.apache.commons.lang.StringUtils;

import string.MyStringUtils;
import junit.framework.TestCase;

public class TestString extends TestCase{
public void testisNumber(){
	String str1="12.3";
	System.out.println(MyStringUtils.isNumber(str1));
}
}
