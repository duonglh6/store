package com.hp.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the promotion_detail database table.
 * 
 */
@Entity
@Table(name="promotion_detail")
@NamedQuery(name="PromotionDetail.findAll", query="SELECT p FROM PromotionDetail p")
public class PromotionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="detail_id")
	private int detailId;

	@Column(name="sale_off")
	private int saleOff;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;

	//bi-directional many-to-one association to Promotion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="promotion_id")
	private Promotion promotion;

	public PromotionDetail() {
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

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

}