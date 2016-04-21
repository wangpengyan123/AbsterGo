package org.AbsterGo.api.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 费用计算工具
 * @author 王晓鹏
 *
 */
public class FeeMsgUtils {
	/**
	 * 等额本息方式计算每期本息
	 * @param account 总借款金额
	 * @param month 借款月数
	 * @param yearInterest 年利率
	 * @param bit 小数保留位数
	 * @return
	 */
	public static double generateRepayFeeByDEBX(double account , int month , double yearInterest , int bit){
		if(account <= 0 || month <= 0){
			throw new IllegalArgumentException("计算等额本息错误 : " + account + " , " + month);
		}
		double monthInterest = yearInterest / 12;
		double  liAll=0.00;
		/**
		 * 当期本息
		 */
		BigDecimal pat = new BigDecimal(Double.valueOf(1 + monthInterest)).pow(month);
		double result = 
			 new BigDecimal(Double.valueOf(monthInterest))
			.multiply(pat)
			.multiply(new BigDecimal(Double.valueOf(account)))
			.divide(pat.subtract(new BigDecimal(Double.valueOf(1))), bit ,BigDecimal.ROUND_HALF_UP)
			.doubleValue();
		/**
		 * 当期本金
		 * B=a*i(1+i)^(n-1)/[(1+i)^N-1]
		 */
		double [] phase = null ;

		
		for(int i = 1 ; i <= month ; i ++){
			phase = new double[3];
			//本息
			phase[0] = result;
			/**
			 * 当期本金
			 */
			phase[1] = new BigDecimal(account)
						.multiply(new BigDecimal(monthInterest))
						.multiply(new BigDecimal(Double.valueOf(1 + monthInterest)).pow(i - 1))
						.divide(new BigDecimal(Double.valueOf(1 + monthInterest)).pow(month)
								.subtract(new BigDecimal(Double.valueOf(1))), bit ,BigDecimal.ROUND_HALF_UP)
						.doubleValue();
			/**
			 * 当期利息 = 当期本息 - 当期本金
			 */
			phase[2] = new BigDecimal(Double.valueOf(phase[0]))
					.subtract(new BigDecimal(phase[1]))
					.divide(new BigDecimal(Double.valueOf(1)), bit ,BigDecimal.ROUND_HALF_UP)
					.doubleValue();
			liAll=liAll+phase[2];
		}
		return  liAll;
	}
	/**
	 * 到期还本付息
	 * @param account
	 * @param month
	 * @param yearInterest
	 * @param bit
	 * @return
	 */
	public static double getRepayDQHB(double account , int month , double yearInterest , int bit){
		if(account <= 0 || month <= 0){
			throw new IllegalArgumentException("计算等额本息错误 : " + account + " , " + month);
		}
		double monthInterest = yearInterest / 12;
		double  liAll=0.00;
		/**
		 * 当期本息
		 */
		double result = 
			 new BigDecimal(Double.valueOf(monthInterest)).multiply(new BigDecimal(Double.valueOf(month))).multiply(new BigDecimal(Double.valueOf(account))).add(new BigDecimal(Double.valueOf(account)))
		
			.doubleValue();
	
		
		
		
		/**
		 * 当期本金
		 * B=account
		 */
		double [] phase = null ;
		List<double[]> list = new ArrayList<double[]>();
		
		
			phase = new double[3];
			//本息
			phase[0] = result;
			/**
			 * 当期本金
			 */
			phase[1] = new BigDecimal(account).doubleValue();
			/**
			 * 当期利息 = 当期本息 - 当期本金
			 */
			phase[2] = new BigDecimal(Double.valueOf(phase[0]))
					.subtract(new BigDecimal(phase[1]))
					.doubleValue();
			liAll=liAll+phase[2];
		
		return liAll ;
	}
	/**
	 * 每月付息到期还本付息
	 * @param account
	 * @param month
	 * @param yearInterest
	 * @param bit
	 * @return
	 */
	public static double generateRepayFeeByFXHB(double account , int month , double yearInterest , int bit){
		if(account <= 0 || month <= 0){
			throw new IllegalArgumentException("计算等额本息错误 : " + account + " , " + month);
		}
		//月利率
		double monthInterest = yearInterest / 12;
		double  liAll=0.00;
		double [] phase = null ;
		List<double[]> list = new ArrayList<double[]>();
		
		for(int i = 1 ; i <= month ; i ++){
			phase = new double[3];
			if(i==month){
				//当期本息
				phase[0] = new BigDecimal(account).multiply(new BigDecimal(monthInterest)).add(new BigDecimal(account)).doubleValue();
				//当期本金
				phase[1] = new BigDecimal(account).doubleValue();
				//当期利息
				phase[2] = new BigDecimal(account).multiply(new BigDecimal(monthInterest)).doubleValue();
			}else{
				phase[0] = new BigDecimal(account).multiply(new BigDecimal(monthInterest)).doubleValue();
				phase[1] = 0;
				phase[2] = new BigDecimal(account).multiply(new BigDecimal(monthInterest)).doubleValue();
			}
			list.add(phase);
			liAll=liAll+phase[2];
		}
		return liAll ;
	}
	
	/**  
	 * getFee(计算费率)  
	 * 
	 * @param scaAmount
	 * @param fee
	 * @return   
	 *BigDecimal  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static BigDecimal getFee(BigDecimal scaAmount, double fee) {
		
		BigDecimal feeValue=BigDecimal.ZERO;
		
		feeValue=scaAmount.multiply(BigDecimal.valueOf(fee));
		
		return feeValue.divide(BigDecimal.valueOf(100),2);
	}
}