package com.mds.configcenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="price_plan")
@Entity
public class PricePlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "price_plan_name")
	private String pricePlanName;
	@Column(name = "description")
	private String description;
	@Column(name="features")
	private String features;

	public PricePlan() {

	}

	public PricePlan(long id, String pricePlanName, String description, String features) {
		super();
		this.id = id;
		this.pricePlanName = pricePlanName;
		this.description = description;
		this.features = features;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPricePlanName() {
		return pricePlanName;
	}

	public void setPricePlanName(String pricePlanName) {
		this.pricePlanName = pricePlanName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	@Override
	public String toString() {
		return "PricePlan [id=" + id + ", pricePlanName=" + pricePlanName + ", description=" + description
				+ ", features=" + features + "]";
	}
}
