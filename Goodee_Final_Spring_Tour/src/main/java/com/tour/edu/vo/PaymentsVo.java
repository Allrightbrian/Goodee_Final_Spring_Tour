package com.tour.edu.vo;

public class PaymentsVo {

	private int paycode;
	private String imp_uid;
	private String pg;
	private String pay_method;
	private String pay_state;
	private int price;
	private String pay_date;
	private String cancelyn;
	private String cancel_date;
	private String cancel_desc;
	private int product_code;
	private String userid;
	private String delflag;
	private String update_date;
	
	public PaymentsVo() {
	}
	
	public PaymentsVo(String imp_uid, String pg, String pay_method, int price, int product_code, String userid) {
		super();
		this.imp_uid = imp_uid;
		this.pg = pg;
		this.pay_method = pay_method;
		this.price = price;
		this.product_code = product_code;
		this.userid = userid;
	}



	@Override
	public String toString() {
		return "PaymentsVo [paycode=" + paycode + ", imp_uid=" + imp_uid + ", pg=" + pg + ", pay_method=" + pay_method
				+ ", pay_state=" + pay_state + ", price=" + price + ", pay_date=" + pay_date + ", cancelyn=" + cancelyn
				+ ", cancel_date=" + cancel_date + ", cancel_desc=" + cancel_desc + ", product_code=" + product_code
				+ ", userid=" + userid + ", delflag=" + delflag + ", update_date=" + update_date + "]";
	}

	public int getPaycode() {
		return paycode;
	}

	public void setPaycode(int paycode) {
		this.paycode = paycode;
	}

	public String getImp_uid() {
		return imp_uid;
	}

	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}

	public String getPg() {
		return pg;
	}

	public void setPg(String pg) {
		this.pg = pg;
	}

	public String getPay_method() {
		return pay_method;
	}

	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}

	public String getPay_state() {
		return pay_state;
	}

	public void setPay_state(String pay_state) {
		this.pay_state = pay_state;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	public String getCancelyn() {
		return cancelyn;
	}

	public void setCancelyn(String cancelyn) {
		this.cancelyn = cancelyn;
	}

	public String getCancel_date() {
		return cancel_date;
	}

	public void setCancel_date(String cancel_date) {
		this.cancel_date = cancel_date;
	}

	public String getCancel_desc() {
		return cancel_desc;
	}

	public void setCancel_desc(String cancel_desc) {
		this.cancel_desc = cancel_desc;
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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
