package com.hp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the promotion database table.
 * 
 */
@Entity
@NamedQuery(name="Promotion.findAll", query="SELECT p FROM Promotion p")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="promotion_id")
	private int promotionId;

	@Lob
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_promotion")
	private Date endPromotion;

	@Column(name="promotion_name")
	private String promotionName;

	@Lob
	@Column(name="promotion_type")
	private String promotionType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_promotion")
	private Date startPromotion;

	//bi-directional many-to-one association to PromotionDetail
	@OneToMany(mappedBy="promotion")
	private List<PromotionDetail> promotionDetails;

	public Promotion() {
	}

	public int getPromotionId() {
		return this.promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndPromotion() {
		return this.endPromotion;
	}

	public void setEndPromotion(Date endPromotion) {
		this.endPromotion = endPromotion;
	}

	public String getPromotionName() {
		return this.promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getPromotionType() {
		return this.promotionType;
	}

	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	public Date getStartPromotion() {
		return this.startPromotion;
	}

	public void setStartPromotion(Date startPromotion) {
		this.startPromotion = startPromotion;
	}

	public List<PromotionDetail> getPromotionDetails() {
		return this.promotionDetails;
	}

	public void setPromotionDetails(List<PromotionDetail> promotionDetails) {
		this.promotionDetails = promotionDetails;
	}

	public PromotionDetail addPromotionDetail(PromotionDetail promotionDetail) {
		getPromotionDetails().add(promotionDetail);
		promotionDetail.setPromotion(this);

		return promotionDetail;
	}

	public PromotionDetail removePromotionDetail(PromotionDetail promotionDetail) {
		getPromotionDetails().remove(promotionDetail);
		promotionDetail.setPromotion(null);

		return promotionDetail;
	}

}