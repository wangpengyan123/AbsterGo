package org.AbsterGo.api.util;
import java.security.*;  
import javax.crypto.*;  
import sun.misc.*;
/**   
* @Title: ToDes.java 
* @Package mob.util 
* @Description:  
* @author 王晓鹏
* @date 2015年1月12日 上午10:03:25 
* @version V1.0   
*/
public class ToDes {
		/**       
		    *   使用DES加密与解密,可对byte[],String类型进行加密与解密  
		    *   密文可使用String,byte[]存储.   
		    *   方法:  
		    *   void getKey(String   strKey)从strKey的字条生成一个Key     
		    *   String getEncString(String strMing)对strMing进行加密,返回String密文  
		    *   String getDesString(String strMi)对strMin进行解密,返回String明文  
		    *   byte[] getEncCode(byte[] byteS)byte[]型的加密  
		    *   byte[] getDesCode(byte[] byteD)byte[]型的解密  
		    */      
		  private static Key key;
		  private static byte[] byteMi = null;
		  private static byte[] byteMing = null;
		  private static String strMi= "";
		  private static String strM= ""; 
		  //  根据参数生成KEY   
		  public static void setKey(String strKey){ 
		   try{  
			   KeyGenerator _generator = KeyGenerator.getInstance("DES");  
		        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );  
	            secureRandom.setSeed(strKey.getBytes());  
	            _generator.init(56,secureRandom); 
//		        _generator.init(new SecureRandom(strKey.getBytes()));  
		        key = _generator.generateKey();  
		        _generator=null;

		        }
		    catch(Exception e){
		     e.printStackTrace();
		     }
		   
		    }  
		  //  加密String明文输入,String密文输出  
		  public static void setEncString(String strMing){
		   BASE64Encoder base64en = new BASE64Encoder();  
		    try {
		     byteMing = strMing.getBytes("UTF8");  
		      byteMi = getEncCode(byteMing);  
		      strMi = base64en.encode(byteMi);
		     }  
		    catch(Exception e)
		    {
		     e.printStackTrace();
		     }
		   finally
		     {
		 
		      byteMing = null;  
		      byteMi = null;
		      }
		  }  
		  //加密以byte[]明文输入,byte[]密文输出    
		  private static byte[] getEncCode(byte[] byteS){
		   byte[] byteFina = null;  
		    Cipher cipher;  
		    try
		     {
		      cipher = Cipher.getInstance("DES");  
		      cipher.init(Cipher.ENCRYPT_MODE,key);  
		      byteFina = cipher.doFinal(byteS);
		      }  
		    catch(Exception e)
		     {
		      e.printStackTrace();
		      }  
		    finally
		    {
		     cipher = null;
		     }
		       
		   return byteFina;
		  } 
		// 解密:以String密文输入,String明文输出   
		  public static void setDesString(String strMi){  
		   BASE64Decoder base64De = new BASE64Decoder();   
		    try
		    {
		     byteMi = base64De.decodeBuffer(strMi);  
		     byteMing = getDesCode(byteMi);  
		      strM = new String(byteMing,"UTF8");  
		      }  
		    catch(Exception e)
		     {
		      e.printStackTrace();
		      }  
		    finally
		     {
		      base64De = null;  
		      byteMing = null;  
		      byteMi = null;
		      }  
		  
		  }
		  // 解密以byte[]密文输入,以byte[]明文输出    
		 private static byte[] getDesCode(byte[] byteD){
		   Cipher cipher;  
		    byte[] byteFina=null;  
		    try{
		     cipher = Cipher.getInstance("DES");  
		      cipher.init(Cipher.DECRYPT_MODE,key);  
		      byteFina = cipher.doFinal(byteD);
		      }
		   catch(Exception e)
		     {
		      e.printStackTrace();
		      }
		   finally
		     {
		      cipher=null;
		      }  
		    return byteFina;
		  } 
		  //返回加密后的密文strMi  
		  public static String getStrMi()
		  {
		   return strMi;
		  }
		  //返回解密后的明文
		  public static String getStrM()
		  {
		   return strM;
		  }
		
}