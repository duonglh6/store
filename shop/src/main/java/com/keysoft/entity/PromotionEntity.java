package com.keysoft.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the promotion database table.
 * 
 */
@Entity
@Table(name="promotion")
@NamedQuery(name="PromotionEntity.findAll", query="SELECT p FROM PromotionEntity p")
public class PromotionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
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

	//bi-directional many-to-one association to PromotionDetailEntity
	@OneToMany(mappedBy="promotion")
	private List<PromotionDetailEntity> promotionDetails;

	public PromotionEntity() {
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

	public List<PromotionDetailEntity> getPromotionDetails() {
		return this.promotionDetails;
	}

	public void setPromotionDetails(List<PromotionDetailEntity> promotionDetails) {
		this.promotionDetails = promotionDetails;
	}

	public PromotionDetailEntity addPromotionDetail(PromotionDetailEntity promotionDetail) {
		getPromotionDetails().add(promotionDetail);
		promotionDetail.setPromotion(this);

		return promotionDetail;
	}

	public PromotionDetailEntity removePromotionDetail(PromotionDetailEntity promotionDetail) {
		getPromotionDetails().remove(promotionDetail);
		promotionDetail.setPromotion(null);

		return promotionDetail;
	}

}