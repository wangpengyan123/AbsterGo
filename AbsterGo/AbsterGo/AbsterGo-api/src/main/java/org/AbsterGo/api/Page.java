package org.AbsterGo.api;

import java.util.List;
/**
 * 异步分页用到的对象
 * 八点金融p2p平台
 * @author chenyuezhi
 * @time 2015年12月9日-下午2:35:09
 * 2015恒实汇通公司-版权所有
 * @version 1.0.0
 *
 */
public class Page<E> { 
   
    /**结果集*/ 
    private List<E> list; 
    /**查询记录数 */    
    private int total; 
    /**每页多少条数据 */    
    private int pageSize; 
    /**第几页**/
    private int pageIndex; 
    
    private boolean success=false;
	
	private String msg="";
    /**
     * 总页数
     * @return
     */ 
    public int getTotalPages() { 
        return (total + pageSize - 1) / pageSize; 
    } 
    /**
     * 取得首页
     * @return
     */ 
    public int getTopPageNo() { 
        return 1; 
    } 
    /**
     * 上一页
     * @return
     */ 
    public int getPreviousPageNo() { 
        if (pageIndex <= 1) { 
            return 1; 
        } 
        return pageIndex - 1; 
    } 
       
    /**
     * 下一页
     * @return
     */ 
    public int getNextPageNo() { 
        if (pageIndex >= getBottomPageNo()) { 
            return getBottomPageNo(); 
        } 
        return pageIndex + 1;   
    } 
       
    /**
     * 取得尾页
     * @return
     */ 
    public int getBottomPageNo() { 
        return getTotalPages(); 
    } 
       
    public List<E> getList() { 
        return list; 
    } 
   
    public void setList(List<E> list) { 
        this.list = list; 
    } 
    public int getPageSize() {
    	if(pageSize == 0){
    		return 10;
    	}
        return pageSize; 
    } 
   
    public void setPageSize(int pageSize) { 
        this.pageSize = pageSize; 
    } 
   
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public boolean isSuccess() {
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
    
}