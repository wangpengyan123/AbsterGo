package org.AbsterGo.api.util;



public class PageUtil {

	private Integer currentpageno;
	
	private Integer allpagenums;
	
	private Integer allrows;
	
	private Integer pagesize;
	
	
	public String url;
	
	public static Integer PAGE_SIZE=15;


	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public Integer getCurrentpageno() {
		return currentpageno;
	}

	public void setCurrentpageno(Integer currentpageno) {
		this.currentpageno = currentpageno;
	}

	public Integer getAllpagenums() {
		
		return allpagenums;
	}

	public void setAllpagenums(Integer allpagenums) {
		this.allpagenums = allpagenums;
	}

	public Integer getAllrows() {
		return allrows;
	}

	public void setAllrows(Integer allrows) {
		allpagenums = allrows%pagesize>0?allrows/pagesize+1:allrows/pagesize;
		this.allrows = allrows;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
