package org.AbsterGo.api.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 
 * @ClassName: FileDown
 * @Description: 文件下载帮助类
 * @author 王晓鹏
 * @date 2014-6-13 下午3:38:43
 * @version V1.0
 */
public class FileDown {

	public static void createExcelByObject(String[] title, List list, File file, String[] keys) {
		try {
			// 创建工作簿
			WritableWorkbook wb = Workbook.createWorkbook(file);
			WritableSheet ws = wb.createSheet("sheet1", 0);
			ws.setColumnView(0, 10);
			ws.setColumnView(1, 30);
			// 设置工作簿样式
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			WritableCellFormat format = new WritableCellFormat(wf);
			format.setBackground(Colour.GREY_40_PERCENT);
			// 表头数据
			for (int i = 0; i < title.length; i++) {
				if (i > 1) {
					ws.setColumnView(i, 20);
				}
				ws.addCell(new Label(i, 0, title[i], format));
			}
			// 表格数据
			if (list != null && list.size() > 0) {
				for (int j = 0; j < list.size(); j++) {
					Map obj = (Map) list.get(j);
					ws.addCell(new Label(0, j + 1, j + 1 + ""));
					for (int k = 0; k < keys.length; k++) {
						if (null!=obj.get(keys[k])) {
						ws.addCell(new Label(k, j + 1, obj.get(keys[k]).toString()));
						}
					}
				}
			}
			// 生成excel文件
			wb.write();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createExcelByMore(String[] title, String[] titles, String[] key, String[] keys, List list,
			File file, String[] sheetName, int sheetSize) {
		try {
			// 创建工作簿
			WritableWorkbook wb = Workbook.createWorkbook(file);

			for (int x = 0; x < sheetSize; x++) {

				if (x == 0) {

					WritableSheet ws = wb.createSheet(sheetName[x], x);

					ws.setColumnView(0, 10);
					ws.setColumnView(1, 30);
					// 设置工作簿样式
					WritableFont wf = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, false,
							UnderlineStyle.NO_UNDERLINE, Colour.BLUE);
					WritableCellFormat format = new WritableCellFormat(wf);
					format.setBackground(Colour.GREY_40_PERCENT);
					// 表头数据
					for (int i = 0; i < title.length; i++) {
						if (i > 1) {
							ws.setColumnView(i, 20);
						}
						ws.addCell(new Label(i, 0, title[i], format));
					}
					// 表格数据
					if (list != null && list.size() > 0) {
						for (int j = 0; j < list.size(); j++) {
							Map obj = (Map) list.get(j);
							ws.addCell(new Label(0, j + 1, j + 1 + ""));
							for (int k = 0; k < key.length; k++) {
								if (null!=obj.get(key[k])) {
									ws.addCell(new Label(k, j + 1, obj.get(key[k]).toString()));
								}
							}
						}
					}
				}

				if (x == 1) {

					WritableSheet ws = wb.createSheet(sheetName[x], x);

					ws.setColumnView(0, 10);
					ws.setColumnView(1, 30);
					// 设置工作簿样式
					WritableFont wf = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, false,
							UnderlineStyle.NO_UNDERLINE, Colour.BLUE);
					WritableCellFormat format = new WritableCellFormat(wf);
					format.setBackground(Colour.GREY_40_PERCENT);
					// 表头数据
					for (int i = 0; i < titles.length; i++) {
						if (i > 1) {
							ws.setColumnView(i, 20);
						}
						ws.addCell(new Label(i, 0, titles[i], format));
					}
					// 表格数据
					if (list != null && list.size() > 0) {
						for (int j = 0; j < list.size(); j++) {
							Map obj = (Map) list.get(j);
							ws.addCell(new Label(0, j + 1, j + 1 + ""));
							for (int k = 0; k < keys.length; k++) {
								if (null!=obj.get(keys[k])) {
								ws.addCell(new Label(k, j + 1, obj.get(keys[k]).toString()));
								}
							}
						}
					}
				}
			}
			// 生成excel文件
			wb.write();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	public static void createExcelByMo(String[] title, String[] titles, String[] key, String[] keys, List list,List list1,
			File file, String[] sheetName, int sheetSize) {
		try {
			// 创建工作簿
			WritableWorkbook wb = Workbook.createWorkbook(file);

			for (int x = 0; x < sheetSize; x++) {

				if (x == 0) {

					WritableSheet ws = wb.createSheet(sheetName[x], x);

					ws.setColumnView(0, 10);
					ws.setColumnView(1, 30);
					// 设置工作簿样式
					WritableFont wf = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, false,
							UnderlineStyle.NO_UNDERLINE, Colour.BLUE);
					WritableCellFormat format = new WritableCellFormat(wf);
					format.setBackground(Colour.GREY_40_PERCENT);
					// 表头数据
					for (int i = 0; i < title.length; i++) {
						if (i > 1) {
							ws.setColumnView(i, 20);
						}
						ws.addCell(new Label(i, 0, title[i], format));
					}
					// 表格数据
					if (list != null && list.size() > 0) {
						for (int j = 0; j < list.size(); j++) {
							Map obj = (Map) list.get(j);
							ws.addCell(new Label(0, j + 1, j + 1 + ""));
							for (int k = 0; k < key.length; k++) {
								if (null!=obj.get(key[k])) {
									ws.addCell(new Label(k, j + 1, obj.get(key[k]).toString()));
								}
							}
						}
					}
				}

				if (x == 1) {

					WritableSheet ws = wb.createSheet(sheetName[x], x);

					ws.setColumnView(0, 10);
					ws.setColumnView(1, 30);
					// 设置工作簿样式
					WritableFont wf = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, false,
							UnderlineStyle.NO_UNDERLINE, Colour.BLUE);
					WritableCellFormat format = new WritableCellFormat(wf);
					format.setBackground(Colour.GREY_40_PERCENT);
					// 表头数据
					for (int i = 0; i < titles.length; i++) {
						if (i > 1) {
							ws.setColumnView(i, 20);
						}
						ws.addCell(new Label(i, 0, titles[i], format));
					}
					// 表格数据
					if (list != null && list1.size() > 0) {
						for (int j = 0; j < list1.size(); j++) {
							Map obj = (Map) list1.get(j);
							ws.addCell(new Label(0, j + 1, j + 1 + ""));
							for (int k = 0; k < keys.length; k++) {
								if (null!=obj.get(keys[k])) {
								ws.addCell(new Label(k, j + 1, obj.get(keys[k]).toString()));
								}
							}
						}
					}
				}
			}
			// 生成excel文件
			wb.write();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 
	 * @Title: downFile
	 * @Description: 文件下载
	 * @author 王晓鹏
	 * @date 2014-6-13 下午3:38:29
	 * @param response
	 * @param file
	 *            void
	 */
	public static void downFile(HttpServletResponse response, File file) {
		try {
			FileInputStream fs = new FileInputStream(file);
			response.reset();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition",
					"attachment; filename=\"" + new String(file.getName().getBytes("gbk"), "iso8859-1") + "\"");
			PrintWriter out = response.getWriter();
			int b = 0;
			while ((b = fs.read()) != -1) {
				out.write(b);
			}
			fs.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: getBytesFromFile
	 * @Description: file转byte[]
	 * @author 王晓鹏
	 * @date 2014-7-28 下午5:35:37
	 * @param f
	 * @return byte[]
	 */
	public static byte[] getBytesFromFile(File f) {
		if (f == null) {
			return null;
		}
		try {
			FileInputStream stream = new FileInputStream(f);
			ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int len;
			while ((len = stream.read(b)) != -1)
				out.write(b, 0, len);
			stream.close();
			out.close();
			return out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Title: getFileFromBytes
	 * @Description: byte[]转file
	 * @author 王晓鹏
	 * @date 2014-7-28 下午5:37:31
	 * @param b
	 * @param outputFile
	 * @return File
	 */
	public static File getFileFromBytes(byte[] b, String outputFile) {
		BufferedOutputStream stream = null;
		File file = null;
		try {
			file = new File(outputFile);
			FileOutputStream fstream = new FileOutputStream(file);
			stream = new BufferedOutputStream(fstream);
			stream.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return file;
	}

	/**
	 * 
	 * @Title: imgCut
	 * @Description: TODO
	 * @author 王晓鹏
	 * @date 2014-7-29 上午9:24:54
	 * @param srcImageFile
	 *            源文件路径
	 * @param dirImageFile
	 *            截取文件路径
	 * @param x
	 * @param y
	 * @param destWidth
	 * @param destHeight
	 *            void
	 */
	public static void imgCut(String srcImageFile, String dirImageFile, int x, int y, int destWidth, int destHeight) {
		try {
			File file = new File(srcImageFile);
			// 读取源图像
			BufferedImage bi = ImageIO.read(file);
			int srcWidth = bi.getWidth(); // 源图宽度
			int srcHeight = bi.getHeight(); // 源图高度
			destWidth = srcWidth < destWidth ? srcWidth : 300;
			destHeight = srcHeight < destHeight ? srcHeight : 300;
			Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
			ImageFilter cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
			Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
			BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(img, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			// 输出为文件
			String afterName = srcImageFile.substring(srcImageFile.lastIndexOf(".") + 1);
			if (afterName.equals("jpg")) {
				ImageIO.write(tag, "JPEG", new File(dirImageFile));
			} else if (afterName.equals("gif")) {
				ImageIO.write(tag, "GIF", new File(dirImageFile));
			} else if (afterName.equals("png")) {
				ImageIO.write(tag, "PNG", new File(dirImageFile));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readExcel(File file) {

		Workbook wb = null;
		StringBuffer sb = new StringBuffer();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			// 传入的是文件,获取工作薄
			wb = Workbook.getWorkbook(file);
			if (wb != null) {
				// 获取所有的工作表
				Sheet[] sheets = wb.getSheets();
				if (sheets != null && sheets.length != 0) {
					for (int i = 0; i < sheets.length; i++) {
						// 获取每一个工作表,此后的操作都在工作表上面进行
						Sheet sheet = wb.getSheet(i);
						// 获取行的长度
						int rows_len = sheet.getRows();
						for (int j = 1; j < rows_len; j++) {

							System.out.println(sheet.getCell(0, j).getContents());

						}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			wb.close();
		}

	}

	public static List<List<String>> readExcelFor(String ExcelURI) {
		// 用于存放所有的行
		List<List<String>> list = new ArrayList<List<String>>();
		Workbook book = null;
		try {
			// 读取现有的工作薄
			book = Workbook.getWorkbook(new File(ExcelURI));
			// 获取工作薄中所有的表对象
			Sheet[] sheets = book.getSheets();
			for (int i = 0; i < sheets.length; i++) {
				// 获取表当前表中的总行数
				int rowSum = sheets[i].getRows();
				for (int j = 1; j < rowSum; j++) {// 如果不想读取表格第一行就把j的初始值设置为1
					// 获取当前行所有单元格对象
					Cell[] rowCells = sheets[i].getRow(j);
					// 用于存放当前行中所有的单元格内容
					List<String> strs = new ArrayList<String>();
					for (int k = 0; k < rowCells.length; k++) {// 如果不想读取表格第一列就把k的初始值设置为1
						// 获取当前单元格对象
						CellType ct = rowCells[k].getType();
						String content = null;
						if (ct.equals(CellType.DATE)) {
							// 日期 类型的处理 ，如果不处理的话，读取的时候表格中的2014-03-25
							// 会读取成14-03-25
							DateCell dc = (DateCell) rowCells[k];
							Date jxlDate = dc.getDate();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
							content = sdf.format(jxlDate);
						} else {
							// 不是日期类型的一律当做字符串处理
							content = rowCells[k].getContents();
						}
						strs.add(content.trim());
					}
					list.add(strs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			book.close();
		}
		return list;
	}

	public static void main(String[] args) {
		String[] str = new String[7];

		Date date = new Date();
		String dateOne = CalendarUtil.DatetoString(date);
		for (int j = 0; j < 7; j++) {

			Date dat = CalendarUtil.getDateBefore(dateOne, j);
			String s = CalendarUtil.DatetoString(dat);

			str[j] = s;
			System.out.println(str[j]);

		}
	}
}
