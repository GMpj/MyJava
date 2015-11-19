package image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import org.junit.Test;

public class MyImgUtil {
	
	private static final Color BACKGROUND_COLOR=Color.WHITE;//验证码背景颜色
	//验证码相框大小
	private static final int WIDTH=100;
	private static final int HEIGHT=40;
	private static final String ImgFormat="JPEG";
@Test
public static void createIdentCode(String fileName) throws IOException{
//	int width=100;//确定框框的大小  
//    int height=40;  
    BufferedImage bfi =new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);  
    Graphics g=bfi.getGraphics();//获得Graphics对象就可以画图  
    //1，设置背景（白框框）  
    g.setColor(BACKGROUND_COLOR);//白色的画笔  
    g.fillRect(0, 0, WIDTH, HEIGHT);//画矩形矩形框框  
    //2，具体生成随机数  
    String str="";//保存数据  
    Random rom=new Random();  
    //设置字体的大写与粗  
    g.setFont(new Font("a",  Font.BOLD,20));  
    
    //画出具体的图片  
      
    for(int i=0;i<4;i++){  
        int num=rom.nextInt(10);//生成的随机数  
        g.setColor(new Color(rom.nextInt(256),rom.nextInt(256), rom.nextInt(256)));//设置画笔的颜色（随机）  
        g.drawString(""+num, 20*i, 20+rom.nextInt(10));//画出线，x的位置每一之间增加20，y的坐标以20一条线，在线上或者是线下  
        //PS：位置需要明确些，  
    }  
    //画出一些干扰线  
    for (int i = 0; i < 10; i++) {  
        g.setColor(new Color(rom.nextInt(256),rom.nextInt(256), rom.nextInt(256)));//设置画笔的颜色（随机）  
        g.drawLine(rom.nextInt(WIDTH),rom.nextInt(HEIGHT), rom.nextInt(WIDTH), rom.nextInt(HEIGHT));//位置也是随机，x，y的值不要超过矩形框框  
    }  
    g.dispose();  
//    ImageIO.write(bfi, "JPEG", res.getOutputStream());//图片用字节流 直接得到  
    
    File f=new File(fileName);
    if (!f.exists()) {
		f.createNewFile();// 不存在则创建
	}
    OutputStream out =new FileOutputStream(f);
    ImageIO.write(bfi, ImgFormat, out);
}
}
