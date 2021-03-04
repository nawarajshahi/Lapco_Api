package com.nawarajshahi.Lapco.Entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Solar {

	@JsonIgnore
	private Long readId;
	private String panelId;
	private Double generatedQty;
	private String message;
	
	@JsonIgnore
	private Set<Restroom> restrooms = new HashSet<Restroom>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "read_id", unique = true, nullable = false)
	public Long getReadId() {
		return this.readId;
	}

	public void setReadId(Long readId) {
		this.readId = readId;
	}

	@Column(name = "panel_id", length = 10)
	public String getPanelId() {
		return this.panelId;
	}

	public void setPanelId(String panelId) {
		this.panelId = panelId;
	}

	@Column(name = "generated_qty", precision = 22, scale = 0)
	public Double getGeneratedQty() {
		return this.generatedQty;
	}

	public void setGeneratedQty(Double generatedQty) {
		this.generatedQty = generatedQty;
	}

	@Column(name = "message", length = 200)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "solar_restroom", 
			joinColumns = @JoinColumn(name = "solar_read_id", referencedColumnName = "read_id"),
			inverseJoinColumns = @JoinColumn(name = "restroom_id", referencedColumnName = "restroom_id"))
	public Set<Restroom> getRestrooms() {
		return restrooms;
	}

	public void setRestrooms(Set<Restroom> restrooms) {
		this.restrooms = restrooms;
	}


	@Override
	public String toString() {
		return "Solar{" +
				"readId=" + readId +
				", panelId='" + panelId + '\'' +
				", generatedQty= " + generatedQty + " kWh" +
				", message='" + message + '\'' +
				", restrooms=" + restrooms +
				'}';
	}
}
