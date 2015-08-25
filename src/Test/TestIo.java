package Test;

import file.IoUtils;
import junit.framework.TestCase;

public class TestIo extends TestCase{
public void testWriteFile(){
	String log="你好";
	String path="/Users/MPJ/My/log.txt";
	String encode="utf-8";
	IoUtils.writeFile(log, path, encode,false);
}
}
