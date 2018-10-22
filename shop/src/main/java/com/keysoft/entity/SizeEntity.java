package com.keysoft.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the size database table.
 * 
 */
@Entity
@Table(name="size")
@NamedQuery(name="SizeEntity.findAll", query="SELECT s FROM SizeEntity s")
public class SizeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="size_id")
	private int sizeId;

	private String size;

	//bi-directional many-to-one association to ProductDetailEntity
	@OneToMany(mappedBy="size")
	private List<ProductDetailEntity> productDetails;

	public SizeEntity() {
	}

	public int getSizeId() {
		return this.sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<ProductDetailEntity> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(List<ProductDetailEntity> productDetails) {
		this.productDetails = productDetails;
	}

	public ProductDetailEntity addProductDetail(ProductDetailEntity productDetail) {
		getProductDetails().add(productDetail);
		productDetail.setSize(this);

		return productDetail;
	}

	public ProductDetailEntity removeProductDetail(ProductDetailEntity productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setSize(null);

		return productDetail;
	}

}