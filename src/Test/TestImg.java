package Test;

import java.io.IOException;

import image.MyImgUtil;
import junit.framework.TestCase;

public class TestImg extends TestCase {

	public void testcreateIdentCode(){
		try {
			MyImgUtil.createIdentCode("/Users/MPJ/My/验证码");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
