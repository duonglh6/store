package com.keysoft.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the color database table.
 * 
 */
@Entity
@Table(name="color")
@NamedQuery(name="ColorEntity.findAll", query="SELECT c FROM ColorEntity c")
public class ColorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="color_id")
	private int colorId;

	@Column(name="color_name")
	private String colorName;

	//bi-directional many-to-one association to ProductDetailEntity
	@OneToMany(mappedBy="color")
	private List<ProductDetailEntity> productDetails;

	public ColorEntity() {
	}

	public int getColorId() {
		return this.colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return this.colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public List<ProductDetailEntity> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(List<ProductDetailEntity> productDetails) {
		this.productDetails = productDetails;
	}

	public ProductDetailEntity addProductDetail(ProductDetailEntity productDetail) {
		getProductDetails().add(productDetail);
		productDetail.setColor(this);

		return productDetail;
	}

	public ProductDetailEntity removeProductDetail(ProductDetailEntity productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setColor(null);

		return productDetail;
	}

}