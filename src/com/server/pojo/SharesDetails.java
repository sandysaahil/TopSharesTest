package com.server.pojo;

/**
 * Share class identifying each element in input file
 * 
 * @author Vivek Arora
 *
 */
public class SharesDetails implements Comparable<SharesDetails>{
	
	private String year;
	private String month;
	private String companyName;
	private double sharePrice;
	
	public SharesDetails(String year2, String month2, double price,
			String string2) {
		this.year = year2;
		this.month = month2;
		this.sharePrice = price;
		this.companyName = string2;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}




	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public double getSharePrice() {
		return sharePrice;
	}



	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	@Override
	public String toString() {
		return "SharesDetails [year=" + year + ", month=" + month
				+ ", companyName=" + companyName + ", sharePrice=" + sharePrice
				+ "]";
	}

	@Override
	public int compareTo(SharesDetails o) {
		if((o).getSharePrice() > this.getSharePrice()){
			return -1;
		}else if((o).getSharePrice() < this.getSharePrice()){
			return 1;
		}else{
			return 0;
		}
		
	}

}
