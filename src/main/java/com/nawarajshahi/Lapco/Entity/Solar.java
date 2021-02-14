package com.nawarajshahi.Lapco.Entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "solar", catalog = "lapco_api")
public class Solar {

	private Long readId;
	private String panelId;
	private Double generatedQty;
	private String message;
	
	@JsonIgnore
	private Set<Restroom> restrooms = new HashSet<Restroom>(0);

	public Solar() {
	}

	public Solar(Long readId, String panelId, Double generatedQty, String message, Set<Restroom> restrooms) {
		super();
		this.readId = readId;
		this.panelId = panelId;
		this.generatedQty = generatedQty;
		this.message = message;
		this.restrooms = restrooms;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
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
			joinColumns = @JoinColumn(name = "read_id", referencedColumnName = "read_id"), 
			inverseJoinColumns = @JoinColumn(name = "restroom_id", referencedColumnName = "restroom_id"))
	public Set<Restroom> getRestrooms() {
		return restrooms;
	}

	public void setRestrooms(Set<Restroom> restrooms) {
		this.restrooms = restrooms;
	}

	
	

}
