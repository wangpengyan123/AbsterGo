package org.AbsterGo.api;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
/**
 * 导出pdf工具类<br>
 * 根据给定的pdf模板，导出pdf文件，并根据给定内容替换pdf中的输入域
 *   
 * ExportPdfUtil  
 *   
 * chenyuezhi  
 * 2016年1月14日 下午2:57:59  
 *   
 * @version 1.0.0  
 *
 */
public class ExportPdfUtil {
	/**
	 * exportpdf(导出pdf工具类)
	 * @param templateName
	 * @param content
	 * @return 
	 * File
	 * @exception 
	 * @since  1.0.0
	 */
	public static File exportpdf(String templateName,Map<String, String> content,String fileName) {
		if(StringUtils.isBlank(fileName)){
			// 以当前时间加上一个随机数获取下载的文件以保证不重名
			// 得到当前时间
			Date now = new Date();
			SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
			String t = dataformat.format(now);
			// 得到一个随机数
			String ran = new Random().nextInt(100)+"";
			// 以当前时间加上一个随机数获取下载的文件以保证不重名
			fileName = t + "-" + ran;
		}
		File file = new File(fileName);
		PdfReader reader = null;
		ByteArrayOutputStream bos = null;
		PdfStamper ps = null;
		FileOutputStream fos = null;
		try {
			// 创建字体
			BaseFont bfChi = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			// 读取pdf
			reader = new PdfReader(ExportPdfUtil.class.getClassLoader().getResourceAsStream(File.separator+PdfConstants.PDF_PATH+File.separator+templateName));
			fos = new FileOutputStream(file);
			ps = new PdfStamper(reader, fos);
			AcroFields s = ps.getAcroFields();
			// 添加所创建的字体
			s.addSubstitutionFont(bfChi);
			// 找到pdf中输入域并替换为内容
			Iterator<String> it = s.getFields().keySet().iterator();
			while (it.hasNext()) {
				String name = (String) it.next();
				s.setField("" + name.trim(), content.get(name.trim()));
			}
			//添加水印和文字
			//ExportLCPdfUtil.addWaterForPdf(reader, ps);
			// 这两步必须有,否则pdf生成失败
			ps.setFormFlattening(true);
			ps.close();
			// 输出pdf
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				reader.close();
			}
			try {
				if (null != bos) {
					bos.close();
				}
			} catch (IOException e) {
				System.out.println("failed to close ByteArrayOutputStream ");
			}
			try {
				if (null != ps) {
					ps.close();
				}
			} catch (DocumentException e) {
				System.out.println("failed to close PdfStamper ");
			} catch (IOException e) {
				System.out.println("failed to close PdfStamper ");
			}
			try {
				if (null != fos) {
					fos.close();
				}
			} catch (IOException e) {
				System.out.println("failed to close FileOutputStream ");
			}
		}
		return file;
	}
	
	/**
	 * exportpdf(导出pdf工具类)  
	 * @param templateName
	 * @param content
	 * @param request 
	 * @param fileName   如果用户传递了生成的文件名称，则以用户的为主，否则 系统自动生成
	 * @return 
	 * File
	 * @exception 
	 * @since  1.0.0
	 */
	public static void exportpdf(String templateName,Map<String, String> content,HttpServletRequest request, HttpServletResponse response,String fileName) {
		if(StringUtils.isBlank(fileName)){
			// 得到当前时间
			Date now = new Date();
			SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
			String t = dataformat.format(now);
			// 得到一个随机数
			String ran = new Random().nextInt(100)+"";
			// 以当前时间加上一个随机数获取下载的文件以保证不重名
			fileName = t + "-" + ran+templateName;
		}
		PdfReader reader = null;
		ByteArrayOutputStream bos = null;
		PdfStamper ps = null;
		try {
			request.setCharacterEncoding("UTF-8");
			// 创建字体
			BaseFont bfChi = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			// 读取pdf
			reader = new PdfReader(ExportPdfUtil.class.getClassLoader().getResourceAsStream(File.separator+PdfConstants.PDF_PATH+File.separator+templateName));
			//处理响应头
			ExportLCPdfUtil.processResponse(request, response, fileName);
			ps = new PdfStamper(reader, response.getOutputStream());
			AcroFields s = ps.getAcroFields();
			// 添加所创建的字体
			s.addSubstitutionFont(bfChi);

			// 找到pdf中输入域并替换为内容
			Iterator<String> it = s.getFields().keySet().iterator();
			while (it.hasNext()) {
				String name = (String) it.next();
				s.setField("" + name.trim(), content.get(name.trim()));
			}
			//添加水印和文字
			ExportLCPdfUtil.addWaterForPdf(reader, ps);
			// 这两步必须有,否则pdf生成失败
			ps.setFormFlattening(true);
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				reader.close();
			}
			try {
				if (null != bos) {
					bos.close();
				}
			} catch (IOException e) {
				System.out.println("failed to close ByteArrayOutputStream ");
			}
			try {
				if (null != ps) {
					ps.close();
				}
			} catch (DocumentException e) {
				System.out.println("failed to close PdfStamper ");
			} catch (IOException e) {
				System.out.println("failed to close PdfStamper ");
			}
		}
	}
}