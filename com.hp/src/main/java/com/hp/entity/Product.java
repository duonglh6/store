package com.hp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	//bi-directional many-to-one association to BillDetail
	@OneToMany(mappedBy="product")
	private List<BillDetail> billDetails;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="product")
	private List<Comment> comments;

	//bi-directional many-to-one association to Catalogue
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="catalogue_id")
	private Catalogue catalogue;

	//bi-directional many-to-one association to ProductDetail
	@OneToMany(mappedBy="product")
	private List<ProductDetail> productDetails;

	//bi-directional many-to-one association to PromotionDetail
	@OneToMany(mappedBy="product")
	private List<PromotionDetail> promotionDetails;

	public Product() {
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

	public List<BillDetail> getBillDetails() {
		return this.billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public BillDetail addBillDetail(BillDetail billDetail) {
		getBillDetails().add(billDetail);
		billDetail.setProduct(this);

		return billDetail;
	}

	public BillDetail removeBillDetail(BillDetail billDetail) {
		getBillDetails().remove(billDetail);
		billDetail.setProduct(null);

		return billDetail;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setProduct(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setProduct(null);

		return comment;
	}

	public Catalogue getCatalogue() {
		return this.catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public List<ProductDetail> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public ProductDetail addProductDetail(ProductDetail productDetail) {
		getProductDetails().add(productDetail);
		productDetail.setProduct(this);

		return productDetail;
	}

	public ProductDetail removeProductDetail(ProductDetail productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setProduct(null);

		return productDetail;
	}

	public List<PromotionDetail> getPromotionDetails() {
		return this.promotionDetails;
	}

	public void setPromotionDetails(List<PromotionDetail> promotionDetails) {
		this.promotionDetails = promotionDetails;
	}

	public PromotionDetail addPromotionDetail(PromotionDetail promotionDetail) {
		getPromotionDetails().add(promotionDetail);
		promotionDetail.setProduct(this);

		return promotionDetail;
	}

	public PromotionDetail removePromotionDetail(PromotionDetail promotionDetail) {
		getPromotionDetails().remove(promotionDetail);
		promotionDetail.setProduct(null);

		return promotionDetail;
	}

}