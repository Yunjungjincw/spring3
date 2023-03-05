package com.ourcom.app3.domain;

import java.util.Date;

public class Product {
	private int sellNo;
	private String itemSize;
	private int desiredSellPrice;
	private int quantity;
	private int goodsGrade;
	private String id;
	private Date startTime;
	private Date endTime;
	private String goods;
	private String vailDate;
	
	
	public Product() {
	}

	public Product(int sellNo, String itemSize, int desiredSellPrice, int quantity, int goodsGrade, String id,
			Date startTime, Date endTime, String goods, String vailDate) {
		this.sellNo = sellNo;
		this.itemSize = itemSize;
		this.desiredSellPrice = desiredSellPrice;
		this.quantity = quantity;
		this.goodsGrade = goodsGrade;
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.goods = goods;
		this.vailDate = vailDate;
	}

	public int getSellNo() {
		return sellNo;
	}

	public void setSellNo(int sellNo) {
		this.sellNo = sellNo;
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}

	public int getDesiredSellPrice() {
		return desiredSellPrice;
	}

	public void setDesiredSellPrice(int desiredSellPrice) {
		this.desiredSellPrice = desiredSellPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getGoodsGrade() {
		return goodsGrade;
	}

	public void setGoodsGrade(int goodsGrade) {
		this.goodsGrade = goodsGrade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getVailDate() {
		return vailDate;
	}

	public void setVailDate(String vailDate) {
		this.vailDate = vailDate;
	}

	@Override
	public String toString() {
		return "Product [sellNo=" + sellNo + ", itemSize=" + itemSize + ", desiredSellPrice=" + desiredSellPrice
				+ ", quantity=" + quantity + ", goodsGrade=" + goodsGrade + ", id=" + id + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", goods=" + goods + ", vailDate=" + vailDate + "]";
	}
	
	
	
	
}
