package com.keysoft.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the product_detail database table.
 * 
 */
@Entity
@Table(name="product_detail")
@NamedQuery(name="ProductDetailEntity.findAll", query="SELECT p FROM ProductDetailEntity p")
public class ProductDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="detail_id")
	private int detailId;

	private int amount;

	@Column(name="start_date")
	private Timestamp startDate;

	//bi-directional many-to-one association to ColorEntity
	@ManyToOne
	@JoinColumn(name="color_id")
	private ColorEntity color;

	//bi-directional many-to-one association to ProductEntity
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity product;

	//bi-directional many-to-one association to SizeEntity
	@ManyToOne
	@JoinColumn(name="size_id")
	private SizeEntity size;

	public ProductDetailEntity() {
	}

	public int getDetailId() {
		return this.detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public ColorEntity getColor() {
		return this.color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
	}

	public ProductEntity getProduct() {
		return this.product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public SizeEntity getSize() {
		return this.size;
	}

	public void setSize(SizeEntity size) {
		this.size = size;
	}

}