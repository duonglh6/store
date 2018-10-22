package com.keysoft.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the catalogue database table.
 * 
 */
@Entity
@Table(name="catalogue")
@NamedQuery(name="CatalogueEntity.findAll", query="SELECT c FROM CatalogueEntity c")
public class CatalogueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="catalogue_id")
	private int catalogueId;

	@Column(name="catalogue_name")
	private String catalogueName;

	@Lob
	@Column(name="catalogue_path")
	private String cataloguePath;

	//bi-directional many-to-one association to ProductEntity
	@OneToMany(mappedBy="catalogue")
	private List<ProductEntity> products;

	public CatalogueEntity() {
	}

	public int getCatalogueId() {
		return this.catalogueId;
	}

	public void setCatalogueId(int catalogueId) {
		this.catalogueId = catalogueId;
	}

	public String getCatalogueName() {
		return this.catalogueName;
	}

	public void setCatalogueName(String catalogueName) {
		this.catalogueName = catalogueName;
	}

	public String getCataloguePath() {
		return this.cataloguePath;
	}

	public void setCataloguePath(String cataloguePath) {
		this.cataloguePath = cataloguePath;
	}

	public List<ProductEntity> getProducts() {
		return this.products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public ProductEntity addProduct(ProductEntity product) {
		getProducts().add(product);
		product.setCatalogue(this);

		return product;
	}

	public ProductEntity removeProduct(ProductEntity product) {
		getProducts().remove(product);
		product.setCatalogue(null);

		return product;
	}

}