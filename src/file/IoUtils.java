package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;

public class IoUtils {
	/**
	 * 字节流 读文件内容
	 * */
	@Test
	public static String fileInputByte(String fileName) throws IOException {
		File f = new File(fileName);
		InputStream in = new FileInputStream(f);
		byte[] b = new byte[1024];
		int len = in.read(b);
		in.close();
		return new String(b);
	}

	/**
	 * 根据编码类型通过字符读取文件
	 * 
	 * @param fileName
	 * @param encoding
	 *            编码类型
	 * @return
	 * @throws IOException
	 */
	@Test
	public static String fileInputString(String fileName, String encoding)
			throws IOException {
		FileInputStream in = new FileInputStream(new File(fileName));
		Reader reader = new InputStreamReader(in, encoding);
		int tempchar;
		StringBuffer bf = new StringBuffer();
		while ((tempchar = reader.read()) != -1) {
			// 对于windows下，\r\n这两个字符在一起时，表示一个换行。
			// 但如果这两个字符分开显示时，会换两次行。
			// 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
			if (((char) tempchar) != '\r') {
				bf.append((char) tempchar);
			}
		}
		reader.close();
		return bf.toString();
	}

	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 * 
	 * @param fileName
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	@Test
	public static String fileInputLine(String fileName, String encoding)
			throws IOException {
		FileInputStream in = new FileInputStream(new File(fileName));
		Reader _reader = new InputStreamReader(in, encoding);
		BufferedReader reader = new BufferedReader(_reader);
		String tempString = null;
		StringBuffer bf = new StringBuffer();
		// 一次读入一行，直到读入null为文件结束
		while ((tempString = reader.readLine()) != null) {
			bf.append(tempString);
		}
		reader.close();
		return bf.toString();
	}

	/**
	 * 递归删除文件夹下面所有文件
	 * 
	 * @param file
	 */
	@Test
	public static void deleteAll(File file) {
		if (file.isFile() || file.list().length == 0) {
			file.delete();
		} else {
			File[] files = file.listFiles();
			for (File f : files) {
				deleteAll(f);// 递归删除每一个文件
				f.delete();// 删除该文件夹
			}
		}
	}

	/**
	 * 写入文件
	 * @param log 写入内容
	 * @param filePath 文件地址
	 * @param encode 文件编码格式
	 * @param flag 是否追加 true 换行追加，false覆盖
	 */
	@Test
	public static void writeFile(String log, String filePath, String encode,
			boolean flag) {
		try {
			String s = new String();
			StringBuffer str = new StringBuffer();
			File f = new File(filePath);
			if (f.exists()) {
				System.out.print("文件存在");
			} else {
				System.out.print("文件不存在");
				f.createNewFile();// 不存在则创建
			}
			if (flag) {
				BufferedReader input = new BufferedReader(new FileReader(f));
				while ((s = input.readLine()) != null) {
					str.append(s + "\n");
				}
				str.append(log);
				input.close();
			} else {
				str.append(log);
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			String write = new String(str.toString().getBytes(), encode);
			output.write(write);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}