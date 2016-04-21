package org.AbsterGo.api.util;

import java.io.Serializable;

/**   
* @Title: ResultBean.java 
* @Package mob.interfaces.util 
* @Description:  返回的结果集
* @author 王晓鹏
* @date 2014年12月25日 下午3:24:38 
* @version V1.0   
*/
public class ResultBean implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean success=false;
	
	private String msg="";
	
	private Object data;
	
	private Object rows;
	

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
