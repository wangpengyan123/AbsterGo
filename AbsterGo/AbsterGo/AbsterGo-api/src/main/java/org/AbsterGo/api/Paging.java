package org.AbsterGo.api;

import java.io.Serializable;

public class Paging implements Serializable{
	/**  
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）  
	 *  
	 * @since 1.0.0  
	 */  
	
	private static final long serialVersionUID = -2805555419058077976L;
	private int mPages=0; // 总页数
	private long mRecords=0;// 总记录数
	private int mCurrentPage = 1;// 当前页
	private int beginIndex = 0;// 起始下标
	private int endIndex = 10;// 结束下标
	private int mpageSize = 10;//每页记录数

    private int pageKey=0;
   


	public int getPageKey() {
		return pageKey;
	}

	public void setPageKey(int pageKey) {
		this.pageKey = pageKey;
	}

	public int getMpageSize() {
		return mpageSize;
	}

	public void setMpageSize(int mpageSize) {
		this.mpageSize = mpageSize;
	}

	

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	private String queryItemOne;
	
	private String queryItemTwo;
	
	private String queryItemThree;
	
    private String queryItemFour;
	
	
	private String queryItemFive;
	
	private String queryItemSix;
	
	private String queryItemSeven;
	private String queryItemEight;
	private String queryItemNine;
	private String userid;


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getQueryItemSeven() {
		return queryItemSeven;
	}

	public void setQueryItemSeven(String queryItemSeven) {
		this.queryItemSeven = queryItemSeven;
	}

	public String getQueryItemEight() {
		return queryItemEight;
	}

	public void setQueryItemEight(String queryItemEight) {
		this.queryItemEight = queryItemEight;
	}

	public String getQueryItemNine() {
		return queryItemNine;
	}

	public void setQueryItemNine(String queryItemNine) {
		this.queryItemNine = queryItemNine;
	}

	
	private String sign;
	
	private String key;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getQueryItemThree() {
		return queryItemThree;
	}

	public void setQueryItemThree(String queryItemThree) {
		this.queryItemThree = queryItemThree;
	}

	public String getQueryItemOne() {
		return queryItemOne;
	}

	public void setQueryItemOne(String queryItemOne) {
		this.queryItemOne = queryItemOne;
	}

	public String getQueryItemTwo() {
		return queryItemTwo;
	}

	public void setQueryItemTwo(String queryItemTwo) {
		this.queryItemTwo = queryItemTwo;
	}

	public int getmPages() {
		return mPages;
	}

	public void setmPages(int mPages) {
		this.mPages = mPages;
	}

	
	
	public Paging() {
		super();
		

	}

	
	
	public String getQueryItemFour() {
		return queryItemFour;
	}

	public void setQueryItemFour(String queryItemFour) {
		this.queryItemFour = queryItemFour;
	}

	public String getQueryItemFive() {
		return queryItemFive;
	}

	public void setQueryItemFive(String queryItemFive) {
		this.queryItemFive = queryItemFive;
	}

	public String getQueryItemSix() {
		return queryItemSix;
	}

	public void setQueryItemSix(String queryItemSix) {
		this.queryItemSix = queryItemSix;
	}

	//计算当前页
	public int getmCurrentPage() {

		if (mCurrentPage <= 0) {
			mCurrentPage = 1;
		}

		if (this.getmPages() < mCurrentPage) // 如果当前页大于数据页
		{
			mCurrentPage = this.getmPages();
		}
		return mCurrentPage;
	}
	public void setmCurrentPage(int mCurrentPage) {
		this.mCurrentPage = mCurrentPage;
	}


	public long getmRecords() {
		return mRecords;
	}

	public void setmRecords(long mRecords) {
		this.mRecords = mRecords;
		long totalPages = mRecords / mpageSize;
		this.mPages += (totalPages + (mRecords % mpageSize == 0 ? 0 : 1));
		if (mRecords <= 0) {
			this.mPages = 1;
		}
		if (mRecords <= mpageSize) {
			this.mPages = 1;
		}
		
		getmCurrentPage();
		if(pageKey!=0){
			this.beginIndex =(int) (( pageKey* mpageSize));
			
		}
		
		this.beginIndex = (int) ((mCurrentPage-1) * mpageSize);
		
		
		this.endIndex =10;
		if(this.endIndex > mRecords){
			this.endIndex = 10;
		}

	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	
}
