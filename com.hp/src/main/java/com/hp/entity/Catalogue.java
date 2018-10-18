package com.hp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the catalogue database table.
 * 
 */
@Entity
@NamedQuery(name="Catalogue.findAll", query="SELECT c FROM Catalogue c")
public class Catalogue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="catalogue_id")
	private int catalogueId;

	@Column(name="catalogue_name")
	private String catalogueName;

	@Lob
	@Column(name="catalogue_path")
	private String cataloguePath;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="catalogue")
	private List<Product> products;

	public Catalogue() {
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

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCatalogue(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCatalogue(null);

		return product;
	}

}