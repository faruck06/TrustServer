package com.trust.trustserver.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Product extends AuditModel {
	@Id
	@GeneratedValue(generator = "question_generator")
	@SequenceGenerator(
			name = "question_generator",
			sequenceName = "question_sequence",
			initialValue = 1000
	)
	private Long id;

	@Column(columnDefinition = "text")
	private String summary;

	@Column(columnDefinition = "text")
	private String image;

	@Column(name = "price_list")
	private Double priceList;

	@Column(name = "price_tag")
	private Double priceTag;

	@Column(columnDefinition = "text")
	private String sku;

	@Column(columnDefinition = "text")
	private String href;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPriceList() {
		return priceList;
	}

	public void setPriceList(Double priceList) {
		this.priceList = priceList;
	}

	public Double getPriceTag() {
		return priceTag;
	}

	public void setPriceTag(Double priceTag) {
		this.priceTag = priceTag;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
