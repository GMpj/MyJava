package utils;

import java.math.BigInteger;
import java.security.MessageDigest;


import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class EncryptUtil {
    public static final String KEY_SHA = "SHA";  
    public static final String KEY_MD5 = "MD5";  
  
    /** 
     * MAC算法可选以下多种算法 
     *  
     * <pre> 
     * HmacMD5  
     * HmacSHA1  
     * HmacSHA256  
     * HmacSHA384  
     * HmacSHA512 
     * </pre> 
     */  
    public static final String KEY_MAC = "HmacMD5";  
  
    /** 
     * BASE64解密 
     *  
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] decryptBASE64(String key) throws Exception {  
        return (new BASE64Decoder()).decodeBuffer(key);  
    }  
  
    /** 
     * BASE64加密 
     *  
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static String encryptBASE64(String key) throws Exception {  
    	String base64 =  new BASE64Encoder().encodeBuffer(key.getBytes());
    	//为方便URL传参取出密文中的"="
    	base64 = base64.replace("=", "");
    	base64 = base64.replace("\n", "");
        return base64;  
    }  
  
    /** 
     * MD5加密 
     *  
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public static String encryptMD5(String data) throws Exception {  
  
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);  
        md5.update(data.getBytes());  
        BigInteger md5BI = new BigInteger(md5.digest());  
        return  md5BI.toString(16);  
  
    }  
  
    /** 
     * SHA加密 
     *  
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public static String encryptSHA(String data) throws Exception {  
  
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);  
        sha.update(data.getBytes());  
        BigInteger shaBI = new BigInteger(sha.digest());  
        return shaBI.toString(32) ;  
    }  
  
   
   
}  
