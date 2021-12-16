package com.tour.edu.vo;

public class ProductsVo {

	private int product_code;
	private String name;
	private int price;
	private String description;
	private String reg_date;
	private String delflag;
	private String update_date;
	
	public ProductsVo() {
	}

	@Override
	public String toString() {
		return "ProductsVo [product_code=" + product_code + ", name=" + name + ", price=" + price + ", description="
				+ description + ", reg_date=" + reg_date + ", delflag=" + delflag + ", update_date=" + update_date
				+ "]";
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	
}
