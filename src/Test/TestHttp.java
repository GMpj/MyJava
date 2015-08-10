package Test;
import http.RequestClient;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase; 
public class TestHttp extends TestCase{

	public void testPost(){
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("name", "sarin");
		parameters.put("pasword", "asdadasd");
		String result = RequestClient.sendPost("http://www.baidu.com",
				parameters);
		System.out.println(result);
	}
	
	public void testGet(){
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("name", "sarin");
		parameters.put("pasword", "asdadasd");
		String result = RequestClient.sendPost("http://www.baidu.com",
				parameters);
		System.out.println(result);
	}
}
