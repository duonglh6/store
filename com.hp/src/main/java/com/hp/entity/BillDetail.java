package com.hp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bill_detail database table.
 * 
 */
@Entity
@Table(name="bill_detail")
@NamedQuery(name="BillDetail.findAll", query="SELECT b FROM BillDetail b")
public class BillDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bill_detail_id")
	private int billDetailId;

	private int amount;

	private String price;

	//bi-directional many-to-one association to Bill
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bill_id")
	private Bill bill;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;

	public BillDetail() {
	}

	public int getBillDetailId() {
		return this.billDetailId;
	}

	public void setBillDetailId(int billDetailId) {
		this.billDetailId = billDetailId;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}