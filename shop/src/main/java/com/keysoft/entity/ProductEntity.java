package com.keysoft.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@NamedQuery(name="ProductEntity.findAll", query="SELECT p FROM ProductEntity p")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private int productId;

	@Lob
	private String description;

	private String giatien;

	@Column(name="product_name")
	private String productName;

	@Lob
	@Column(name="product_path")
	private String productPath;

	//bi-directional many-to-one association to BillDetailEntity
	@OneToMany(mappedBy="product")
	private List<BillDetailEntity> billDetails;

	//bi-directional many-to-one association to CommentEntity
	@OneToMany(mappedBy="product")
	private List<CommentEntity> comments;

	//bi-directional many-to-one association to CatalogueEntity
	@ManyToOne
	@JoinColumn(name="catalogue_id")
	private CatalogueEntity catalogue;

	//bi-directional many-to-one association to ProductDetailEntity
	@OneToMany(mappedBy="product")
	private List<ProductDetailEntity> productDetails;

	//bi-directional many-to-one association to PromotionDetailEntity
	@OneToMany(mappedBy="product")
	private List<PromotionDetailEntity> promotionDetails;

	public ProductEntity() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGiatien() {
		return this.giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPath() {
		return this.productPath;
	}

	public void setProductPath(String productPath) {
		this.productPath = productPath;
	}

	public List<BillDetailEntity> getBillDetails() {
		return this.billDetails;
	}

	public void setBillDetails(List<BillDetailEntity> billDetails) {
		this.billDetails = billDetails;
	}

	public BillDetailEntity addBillDetail(BillDetailEntity billDetail) {
		getBillDetails().add(billDetail);
		billDetail.setProduct(this);

		return billDetail;
	}

	public BillDetailEntity removeBillDetail(BillDetailEntity billDetail) {
		getBillDetails().remove(billDetail);
		billDetail.setProduct(null);

		return billDetail;
	}

	public List<CommentEntity> getComments() {
		return this.comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public CommentEntity addComment(CommentEntity comment) {
		getComments().add(comment);
		comment.setProduct(this);

		return comment;
	}

	public CommentEntity removeComment(CommentEntity comment) {
		getComments().remove(comment);
		comment.setProduct(null);

		return comment;
	}

	public CatalogueEntity getCatalogue() {
		return this.catalogue;
	}

	public void setCatalogue(CatalogueEntity catalogue) {
		this.catalogue = catalogue;
	}

	public List<ProductDetailEntity> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(List<ProductDetailEntity> productDetails) {
		this.productDetails = productDetails;
	}

	public ProductDetailEntity addProductDetail(ProductDetailEntity productDetail) {
		getProductDetails().add(productDetail);
		productDetail.setProduct(this);

		return productDetail;
	}

	public ProductDetailEntity removeProductDetail(ProductDetailEntity productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setProduct(null);

		return productDetail;
	}

	public List<PromotionDetailEntity> getPromotionDetails() {
		return this.promotionDetails;
	}

	public void setPromotionDetails(List<PromotionDetailEntity> promotionDetails) {
		this.promotionDetails = promotionDetails;
	}

	public PromotionDetailEntity addPromotionDetail(PromotionDetailEntity promotionDetail) {
		getPromotionDetails().add(promotionDetail);
		promotionDetail.setProduct(this);

		return promotionDetail;
	}

	public PromotionDetailEntity removePromotionDetail(PromotionDetailEntity promotionDetail) {
		getPromotionDetails().remove(promotionDetail);
		promotionDetail.setProduct(null);

		return promotionDetail;
	}

}