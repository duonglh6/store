package com.keysoft.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bill_detail database table.
 * 
 */
@Entity
@Table(name="bill_detail")
@NamedQuery(name="BillDetailEntity.findAll", query="SELECT b FROM BillDetailEntity b")
public class BillDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bill_detail_id")
	private int billDetailId;

	private int amount;

	private String price;

	//bi-directional many-to-one association to BillEntity
	@ManyToOne
	@JoinColumn(name="bill_id")
	private BillEntity bill;

	//bi-directional many-to-one association to ProductEntity
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity product;

	public BillDetailEntity() {
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

	public BillEntity getBill() {
		return this.bill;
	}

	public void setBill(BillEntity bill) {
		this.bill = bill;
	}

	public ProductEntity getProduct() {
		return this.product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

}