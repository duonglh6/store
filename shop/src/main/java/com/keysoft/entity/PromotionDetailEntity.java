package com.keysoft.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the promotion_detail database table.
 * 
 */
@Entity
@Table(name="promotion_detail")
@NamedQuery(name="PromotionDetailEntity.findAll", query="SELECT p FROM PromotionDetailEntity p")
public class PromotionDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="detail_id")
	private int detailId;

	@Column(name="sale_off")
	private int saleOff;

	//bi-directional many-to-one association to ProductEntity
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity product;

	//bi-directional many-to-one association to PromotionEntity
	@ManyToOne
	@JoinColumn(name="promotion_id")
	private PromotionEntity promotion;

	public PromotionDetailEntity() {
	}

	public int getDetailId() {
		return this.detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getSaleOff() {
		return this.saleOff;
	}

	public void setSaleOff(int saleOff) {
		this.saleOff = saleOff;
	}

	public ProductEntity getProduct() {
		return this.product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public PromotionEntity getPromotion() {
		return this.promotion;
	}

	public void setPromotion(PromotionEntity promotion) {
		this.promotion = promotion;
	}

}