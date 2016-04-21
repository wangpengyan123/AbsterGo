package org.AbsterGo.api;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.AbsterGo.api.param.PdfDept;
import org.AbsterGo.api.util.CalendarUtil;
import org.AbsterGo.api.util.ParamsUtil;
import org.AbsterGo.api.util.UserAgentUtil;
import org.apache.commons.lang3.StringUtils;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 * 导出理财计划pdf
 * 八点金融p2p平台
 * @author chenyuezhi
 * @time 2016年1月13日-下午2:44:44
 * 2016恒实汇通公司-版权所有
 * @version 1.0.0
 *
 */
public class ExportLCPdfUtil {
	/**
	 * exportpdf(导出pdf工具类)  
	 * @param templateName
	 * @param content
	 * @param pdfDebts 
	 * @param request 
	 * @param fileName  如果用户传递了生成的文件名称，则以用户的为主，否则 系统自动生成
	 * @return 
	 * File
	 * @throws IOException 
	 * @throws DocumentException 
	 * @exception 
	 * @since  1.0.0
	 */
	public static void exportpdf(String templateName,Map<String, String> params,List<PdfDept> pdfDebts, HttpServletRequest request, HttpServletResponse response,String fileName){
		//创建pdf
		Document doc = new Document(PageSize.A4);
		try {
			request.setCharacterEncoding("UTF-8");
			//生成文件名称
			if(StringUtils.isBlank(fileName)){
				fileName = ParamsUtil.getTimeFileName()+templateName;
			}
			processResponse(request, response, fileName);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(doc, baos);
			doc.open();
			
			Font cwFont = getCNFont();
			cwFont.setSize(13.0f);

			//标题字体
			Font titleFont = getCNFont();
			titleFont.setSize(18.0f);
			titleFont.setStyle(Font.BOLD);
			//标题
			Paragraph titleP = new Paragraph("债权转让及受让协议",titleFont);
			titleP.setSpacingBefore(20f);
			titleP.setSpacingAfter(20f);
			titleP.setAlignment(Element.ALIGN_CENTER);
			doc.add(titleP);
			
			//内容字体
			Font font =  getCNFont();
			Paragraph content = new Paragraph("就甲方通过上海钦嘉金融信息服务有限公司运营管理的八点金融（域名为http://www.8dbank.com）向乙方进行债权转让事宜，甲乙丙三方根据平等、自愿的原则，达成协议如下：",font);
			content.setFirstLineIndent(20.0f);
			doc.add(content);
			//加粗字体
			Font boldFont = getCNFont();
			boldFont.setStyle(Font.BOLD);
			boldFont.setSize(12.0f);
			content = new Paragraph("1、债权转让基本信息",boldFont);
			doc.add(content);
			
			//生成16列的表格
			PdfPTable table = new PdfPTable(16);
			table.setWidthPercentage(100);
			tableAddCell(table, "债权转让及受让主体", boldFont, 16, Element.ALIGN_CENTER);
			
			tableAddCell(table, "转让人（甲方）", font, 8, Element.ALIGN_CENTER);
			tableAddCell(table, "受让人（乙方）", font, 8, Element.ALIGN_CENTER);
			
			tableAddCell(table, "姓名", font, 4, Element.ALIGN_LEFT);
			tableAddCell(table, params.get(PdfConstants.PDF_PARAM_DEBT_ZRR), font, 4, Element.ALIGN_LEFT);
			tableAddCell(table, "姓名", font, 4, Element.ALIGN_LEFT);
			tableAddCell(table,params.get(PdfConstants.PDF_PARAM_DEBT_SRR), font, 4, Element.ALIGN_LEFT);

			tableAddCell(table, "身份证号", font, 4, Element.ALIGN_LEFT);
			tableAddCell(table, params.get(PdfConstants.PDF_PARAM_DEBT_ZRR_SFZH), font, 4, Element.ALIGN_LEFT);
			tableAddCell(table, "身份证号", font, 4, Element.ALIGN_LEFT);
			tableAddCell(table,params.get(PdfConstants.PDF_PARAM_DEBT_SRR_SFZH), font, 4, Element.ALIGN_LEFT);
			
			tableAddCell(table, "手机号", font, 4, Element.ALIGN_LEFT);
			tableAddCell(table, params.get(PdfConstants.PDF_PARAM_DEBT_ZRR_SJH), font, 4, Element.ALIGN_LEFT);
			tableAddCell(table, "手机号", font, 4, Element.ALIGN_LEFT);
			tableAddCell(table,params.get(PdfConstants.PDF_PARAM_DEBT_SRR_SJH), font, 4, Element.ALIGN_LEFT);
			
			tableAddCell(table, "服务方（丙方）", font, 16, Element.ALIGN_CENTER);
			tableAddCell(table, "公司名称", font, 6, Element.ALIGN_LEFT);
			tableAddCell(table, "上海钦嘉金融信息服务有限公司（“八点金融”）", font, 10, Element.ALIGN_LEFT);
			tableAddCell(table, "转让人服务费", font, 6, Element.ALIGN_LEFT);
			tableAddCell(table,"转让金额 × 转让服务费率", font, 10, Element.ALIGN_LEFT);
			tableAddCell(table, "受让人账户管理费", font, 6, Element.ALIGN_LEFT);
			tableAddCell(table,"受让金额 × 账户管理费率", font, 10, Element.ALIGN_LEFT);
			
			
			tableAddCell(table, "标的债权信息", boldFont, 16, Element.ALIGN_CENTER);
			
			tableAddCell(table, "转让债权基本信息", font, 10, Element.ALIGN_CENTER);
			tableAddCell(table, "债权收益信息", font, 6, Element.ALIGN_CENTER);
			//表格标题
			tableAddCell(table, "序号", font, 1, Element.ALIGN_CENTER);
			tableAddCell(table, "借款人姓名", font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, "借款人身份证号码", font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, "本次转让债权价值", font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, "需支付对价", font, 1, Element.ALIGN_CENTER);
			tableAddCell(table, "借款类型", font, 1, Element.ALIGN_CENTER);
			tableAddCell(table, "借款信息", font, 1, Element.ALIGN_CENTER);
			
			tableAddCell(table, "还款起始日期", font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, "还款期限(月)", font, 1, Element.ALIGN_CENTER);
			tableAddCell(table, "剩余还款月数", font, 1, Element.ALIGN_CENTER);
			tableAddCell(table, "预计债权收益率(年)", font, 2, Element.ALIGN_CENTER);

			BigDecimal totalBczrDebtValue = BigDecimal.ZERO;
			BigDecimal totalXzfdj = BigDecimal.ZERO;
			for (PdfDept debt : pdfDebts) {
				tableAddCell(table, debt.getNo(), font, 1, Element.ALIGN_CENTER);//序号
				tableAddCell(table, CalendarUtil.hideSomeChar(debt.getJkrName(), Constants.REALNAME), font, 2, Element.ALIGN_CENTER);//借款人姓名
				tableAddCell(table, CalendarUtil.hideSomeChar(debt.getJkrIdCardno(), Constants.IDCARD), font, 2, Element.ALIGN_CENTER);//借款人身份证号码
				tableAddCell(table, debt.getBczrDebtValue(), font, 2, Element.ALIGN_CENTER);//本次转让债权价值
				if(StringUtils.isNotBlank(debt.getBczrDebtValue())){
					totalBczrDebtValue = totalBczrDebtValue.add(new BigDecimal(debt.getBczrDebtValue()));
				}
				tableAddCell(table, debt.getXzfdj(), font, 1, Element.ALIGN_CENTER);//需支付对价
				if(StringUtils.isNotBlank(debt.getXzfdj())){
					totalXzfdj = totalXzfdj.add(new BigDecimal(debt.getXzfdj()));
				}
				
				
				tableAddCell(table, debt.getJkType(), font, 1, Element.ALIGN_CENTER);//借款类型
				
				tableAddCell(table, debt.getJkInfo(), font, 1, Element.ALIGN_CENTER);//借款信息
				
				tableAddCell(table, debt.getHkBeginEndTime(), font, 2, Element.ALIGN_CENTER);//还款起始日期
				tableAddCell(table, debt.getHkMonths(), font, 1, Element.ALIGN_CENTER);//还款期限(月)
				tableAddCell(table, debt.getSyhkMonths(), font, 1, Element.ALIGN_CENTER);//剩余还款月数
				tableAddCell(table, debt.getYqDebtRate(), font, 2, Element.ALIGN_CENTER);//预计债权收益率(年)
			}
			//合计
			tableAddCell(table, "合计", font, 3, Element.ALIGN_CENTER);//合计
			tableAddCell(table, "", font, 2, Element.ALIGN_CENTER);//借款人身份证号码
			tableAddCell(table, totalBczrDebtValue.setScale(2).toString(), font, 2, Element.ALIGN_CENTER);//本次转让债权价值
			tableAddCell(table, totalXzfdj.setScale(2).toString(), font, 1, Element.ALIGN_CENTER);//需支付对价
			tableAddCell(table, "", font, 1, Element.ALIGN_CENTER);
			tableAddCell(table, "", font, 1, Element.ALIGN_CENTER);
			
			tableAddCell(table, "", font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, "", font, 1, Element.ALIGN_CENTER);
			tableAddCell(table, "", font, 1, Element.ALIGN_CENTER);
			tableAddCell(table, "", font, 2, Element.ALIGN_CENTER);
			
			
			tableAddCell(table, "受让债权明细", boldFont, 16, Element.ALIGN_CENTER);
			tableAddCell(table, "合同编号", font, 3, Element.ALIGN_CENTER);
			tableAddCell(table, "资金出借及回收方式", font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, "初始出借日期", font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, "初始出借金额", font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, "下一个报告日", font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, "到期日期", font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, "到期时预计累计资产总额", font, 3, Element.ALIGN_CENTER);
			
			tableAddCell(table, params.get(PdfConstants.PDF_PARAM_HTBH), font, 3, Element.ALIGN_CENTER);
			tableAddCell(table, params.get(PdfConstants.PDF_PARAM_ZJCJ_JHSFS), font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, params.get(PdfConstants.PDF_PARAM_CS_CJRQ), font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, params.get(PdfConstants.PDF_PARAM_CS_CJJE), font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, params.get(PdfConstants.PDF_PARAM_XYG_BGR), font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, params.get(PdfConstants.PDF_PARAM_DQRQ), font, 2, Element.ALIGN_CENTER);
			tableAddCell(table, params.get(PdfConstants.PDF_PARAM_DQR_ZCZE), font, 3, Element.ALIGN_CENTER);
			//设置表格样式
			setTableStyle(table);
			table.setSpacingBefore(15.0f);
			doc.add(table);
			doc.newPage();
			
			content = new Paragraph("2、债权转让流程",boldFont);
			content.setSpacingBefore(25f);
			doc.add(content);
			content = new Paragraph("2.1 甲乙双方同意并确认，双方根据八点金融网站有关规则和说明，通过在八点金融网站进行债权转让和受让操作等方式确认签署本协议。",font);
			doc.add(content);
			content = new Paragraph("2.2 甲乙丙三方签署本协议时，本协议立即成立,并待转让价款支付完成时生效。",font);
			doc.add(content);
			content = new Paragraph("2.3协议成立的同时，乙方不可撤销地授权八点金融委托的银行或第三方支付机构，将转让价款划转、支付给甲方；同时甲方不可撤销地授权八点金融将其代为保管的甲方与标的债权借款人签署的《借款协议》（下称“借款协议”）及借款人相关信息在八点金融网站有关系统板块向乙方进行展示。",font);
			doc.add(content);
			content = new Paragraph("2.4 本协议生效且标的债权转让成功后，甲乙双方特此委托八点金融将标的债权的转让事项及有关信息通过站内信等形式通知与标的债权对应的借款人。",font);
			doc.add(content);
			content = new Paragraph("2.5 自本协议生效之日起，乙方成为标的债权的债权人，承继借款协议项下出借人的权利并承担出借人的义务。",font);
			doc.add(content);
			
			content = new Paragraph("3、税费",boldFont);
			doc.add(content);
			content = new Paragraph("受让人应自行承担并缴纳其因受让甲方转让的债权所获收益的税费。",font);
			doc.add(content);
			
			content = new Paragraph("4、保证与承诺",boldFont);
			doc.add(content);
			content = new Paragraph("4.1 甲方保证其转让的债权系其合法、有效的债权，不存在转让的限制。",font);
			doc.add(content);
			content = new Paragraph("4.2 甲乙双方同意并承诺按有关协议及八点金融网站的相关规则和说明向八点金融支付债权转让服务费及账户管理费。",font);
			doc.add(content);
			content = new Paragraph("4.3 乙方保证其所用于受让标的债权的资金来源合法，乙方是该资金的合法所有人。如果第三方对资金归属、合法性问题发生争议，乙方应自行负责解决并承担相关责任。",font);
			doc.add(content);
			
			content = new Paragraph("5、违约",boldFont);
			doc.add(content);
			content = new Paragraph("5.1 甲乙双方同意，如果一方违反其在本协议中所作的保证、承诺或任何其他义务，致使其他方遭受或发生损害、损失等责任，违约方须向守约方赔偿守约方因此遭受的一切经济损失。",font);
			doc.add(content);
			content = new Paragraph("5.2 甲乙双方均有过错的，应根据双方实际过错程度，分别承担各自的违约责任。",font);
			doc.add(content);
			
			content = new Paragraph("6、适用法律和争议解决",boldFont);
			doc.add(content);
			content = new Paragraph("6.1 本协议的订立、效力、解释、履行、修改和终止以及争议的解决适用中国的法律。",font);
			doc.add(content);
			content = new Paragraph("6.2 本协议在履行过程中，如发生任何争执或纠纷，甲乙丙三方应友好协商解决；若协商不成，任何一方均有权向有管辖权的人民法院提起诉讼。",font);
			doc.add(content);
			
			content = new Paragraph("7、其他",boldFont);
			doc.add(content);
			content = new Paragraph("7.1 甲乙丙三方可以书面协议方式对本协议做出修改和补充。经过三方签署的有关本协议的修改协议和补充协议是本协议组成部分，具有与本协议同等的法律效力。",font);
			doc.add(content);
			content = new Paragraph("7.2 本协议及其修改或补充均通过八点金融网站以电子文本形式制成，自甲乙丙三方通过电子签章或以线上点击确认之日起生效，可以有一份或者多份并且每一份具有同等法律效力；同时甲乙双方委托八点金融代为保管并永久保存在八点金融为此设立的专用服务器上备查。甲乙丙三方均认可该形式的协议效力。",font);
			doc.add(content);
			content = new Paragraph("7.3 甲乙丙三方均确认，本协议的签订、生效和履行以不违反中国的法律法规为前提。如果本协议中的任何一条或多条违反适用的法律法规，则该条将被视为无效，但该无效条款并不影响本协议其他条款的效力。",font);
			doc.add(content);
			content = new Paragraph("7.4 除本协议上下文另有定义外，本协议项下的用语和定义应具有八点金融网站服务协议及其有关规则中定义的含义。若有冲突，则以本协议为准。",font);
			doc.add(content);
			
			content = new Paragraph("（以下无正文）",font);
			content.setFirstLineIndent(5);
			content.setSpacingBefore(15);
			doc.add(content);
			
			content = new Paragraph("甲方："+params.get(PdfConstants.PDF_PARAM_DEBT_ZRR),font);
			content.setSpacingBefore(10);
			doc.add(content);
			
			content = new Paragraph("乙方："+params.get(PdfConstants.PDF_PARAM_DEBT_SRR),font);
			content.setSpacingBefore(10);
			doc.add(content);
			
			Image hengShiImage = getWaterImage();
			table = setWaterImageGZTable(font, hengShiImage, "丙方：");
			doc.add(table);
			
	        doc.close();
			PdfReader reader = new PdfReader(baos.toByteArray());
			PdfStamper stamper = new PdfStamper(reader, response.getOutputStream());
			//添加水印文字
			addWaterForPdf(reader, stamper);
            stamper.close();
            response.getOutputStream().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/***
	 * 
	 * setWaterImageGZTable(设置盖章表格样式)  
	 * @param font
	 * @param hengShiImage
	 * @return   
	 *PdfPTable  
	 * @exception   
	 * @since  1.0.0
	 */
	private static PdfPTable setWaterImageGZTable(Font font, Image hengShiImage,String label) {
		PdfPTable subTable = new PdfPTable(10);
		subTable.setWidthPercentage(100);
		if(StringUtils.isEmpty(label)){
			label = "盖章：";
		}
		PdfPCell subCell = new PdfPCell(new Phrase(label, font));
		subTable.addCell(subCell);
		subCell = new PdfPCell(hengShiImage);
		subCell.setColspan(9);
		subTable.addCell(subCell);
		setTableStyleNo(subTable);
		return subTable;
	}
	private static void setTableStyleNo(PdfPTable table) {
		for (PdfPRow row: (ArrayList<PdfPRow>)table.getRows()) {
			for (PdfPCell cells:row.getCells()) {
				if(cells!=null){
					cells.setPaddingLeft(0);
					cells.setBorderWidth(0);
					cells.setHorizontalAlignment(Element.ALIGN_LEFT);
					cells.setVerticalAlignment(Element.ALIGN_MIDDLE);
				}
			}
		}
	}
	
	private static void setTableStyle(PdfPTable table) {
		for (PdfPRow row: (ArrayList<PdfPRow>)table.getRows()) {
			for (PdfPCell cells:row.getCells()) {
				if(cells!=null){
					cells.setPadding(1f);
					cells.setPaddingRight(2f);
					cells.setPaddingBottom(5.0f);
					cells.setVerticalAlignment(Element.ALIGN_MIDDLE);
				}
			}
		}
	}
	
	/****
	 * 获取中文字体
	 * @return
	 */
	public static Font getCNFont(){
		return FontFactory.getFont("STSongStd-Light",  "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED, 10.0f);
	}
	
	/****
	 * 获取英文字体
	 * @return
	 */
	public static Font getENFont(){
		return FontFactory.getFont("simhei", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED,10.0f);
	}
	
	/****
	 * 添加水印
	 */
	public static void addWaterForPdf(PdfReader reader, PdfStamper stamper){
		try {
			String waterMarkName = "www.8dbank.com";
			// 设置透明度为0.4
			PdfContentByte content = null;
	        BaseFont base = BaseFont.createFont(BaseFont.TIMES_ROMAN, "Cp1252", BaseFont.NOT_EMBEDDED);
	        Rectangle pageRect = null;
	        PdfGState gs = new PdfGState();
            gs.setFillOpacity(0.8f);
            gs.setStrokeOpacity(0.8f);
            int toPage = stamper.getReader().getNumberOfPages();
           // Image headImage = getHeaderImage();
            //headImage.setAbsolutePosition(450, 790);  
            for (int i = 1; i <= toPage; i++) {
                pageRect = stamper.getReader().getPageSizeWithRotation(i);
                // 计算水印X,Y坐标
                float x = pageRect.getWidth() / 2-10;
                float y = pageRect.getHeight() / 2;
                //获得PDF最顶层
                content = stamper.getUnderContent(i);
                content.saveState();
                // set Transparency
                content.setGState(gs);
                content.beginText();
                content.setColorFill(BaseColor.LIGHT_GRAY);
                content.setFontAndSize(base, 75);
                // 水印文字成45度角倾斜
                content.showTextAligned(Element.ALIGN_CENTER, waterMarkName, x, y+120, -45);
                content.showTextAligned(Element.ALIGN_CENTER, waterMarkName, x, y-120, -45);
                content.endText(); 
                //content.addImage(headImage);
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	/**
	 * 
	 * processResponse(处理下载头信息，判断是下载，还是在线预览)  
	 * @param request
	 * @param response
	 * @param fileName   
	 *void  
	 * @exception   
	 * @since  1.0.0
	 */
	public static void processResponse(HttpServletRequest request, HttpServletResponse response, String fileName) {
		response.setContentType("application/pdf");
		String downFlag = request.getParameter("downloadFlag");
		if("1".equals(downFlag)){
			response.setHeader("Content-Disposition", "attachment;" + UserAgentUtil.encodeFileName(request, fileName));
		}else{
			response.setHeader("Content-Disposition", "inline;" + UserAgentUtil.encodeFileName(request, fileName));
		}
	}
	/**
	 * 
	 * getWaterImage(获得水印图片)  
	 * @return   
	 *Image  
	 * @exception   
	 * @since  1.0.0
	 */
	public static Image getWaterImage(){
		Image hengShiImage;
		try {
			hengShiImage = Image.getInstance(ExportLCPdfUtil.class.getClassLoader().getResource(PdfConstants.PDF_PATH+File.separator+ "hengshi.png"));
			hengShiImage.scaleToFit(120.f,125.f);
			return hengShiImage;
		} catch (BadElementException | IOException e) {
			e.printStackTrace();
		}  
		return null;
	}
	/**
	 * 
	 * getWaterImage(获得水印图片)  
	 * @return   
	 *Image  
	 * @exception   
	 * @since  1.0.0
	 */
	public static Image getHeaderImage(){
		Image hengShiImage;
		try {
			hengShiImage = Image.getInstance(ExportLCPdfUtil.class.getClassLoader().getResource(PdfConstants.PDF_PATH+File.separator+ "head.png"));
			hengShiImage.scaleToFit(120.f,45.f);
			return hengShiImage;
		} catch (BadElementException | IOException e) {
			e.printStackTrace();
		}  
		return null;
	}
	/**
	 * createCell(创建pdf)  
	 * @param content
	 * @param font
	 * @param colspan
	 * @return   
	 *PdfPCell  
	 * @exception   
	 * @since  1.0.0
	 */
	public static PdfPCell createCell(String content,Font font,int colspan,Integer location){
		PdfPCell cell = new PdfPCell(new Paragraph(content,font));
		cell.setColspan(colspan);
		if(location==null){
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		}else{
			cell.setHorizontalAlignment(location);
		}
		return cell;
	}
	
	/**
	 * 
	 * tableAddCell(添加单元格至表格)  
	 * @param table
	 * @param content
	 * @param font
	 * @param colspan
	 * @return   
	 *PdfPTable  
	 * @exception   
	 * @since  1.0.0
	 */
	public static PdfPTable tableAddCell(PdfPTable table,String content,Font font,int colspan,Integer location){
		table.addCell(createCell(content,font,colspan,location));
		return table;
	}
}
