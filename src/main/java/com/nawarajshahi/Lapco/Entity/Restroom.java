package com.nawarajshahi.Lapco.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table
public class Restroom implements Serializable {


	private Long restroomId;
	private Address address;
	private String serialNo;
	private String modelNo;
	private Date dateInstalled;
	private Double totalCostOfProduction;
	private Double totalCostOfInstallation;

	@JsonIgnore
	private Set<CoinSensor> coinSensors = new HashSet<CoinSensor>(0);

	@JsonIgnore
	private Set<ElectricBill> electricBills = new HashSet<ElectricBill>(0);

	@JsonIgnore
	private Set<WaterBill> waterBills = new HashSet<WaterBill>(0);

	@JsonIgnore
	private Set<DoorSensor> doorSensors = new HashSet<DoorSensor>(0);

	@JsonIgnore
	private Set<Solar> solars = new HashSet<Solar>(0);


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "restroom_id", unique = true, nullable = false)
	public Long getRestroomId() {
		return this.restroomId;
	}

	public void setRestroomId(Long restroomId) {
		this.restroomId = restroomId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "serial_no", length = 10)
	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	@Column(name = "model_no", length = 10)
	public String getModelNo() {
		return this.modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateInstalled", length = 19)
	public Date getDateInstalled() {
		return this.dateInstalled;
	}

	public void setDateInstalled(Date dateInstalled) {
		this.dateInstalled = dateInstalled;
	}

	@Column(name = "TotalCostOfProduction", precision = 22, scale = 0)
	public Double getTotalCostOfProduction() {
		return this.totalCostOfProduction;
	}

	public void setTotalCostOfProduction(Double totalCostOfProduction) {
		this.totalCostOfProduction = totalCostOfProduction;
	}

	@Column(name = "TotalCostOfInstallation", precision = 22, scale = 0)
	public Double getTotalCostOfInstallation() {
		return this.totalCostOfInstallation;
	}

	public void setTotalCostOfInstallation(Double totalCostOfInstallation) {
		this.totalCostOfInstallation = totalCostOfInstallation;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restroom")
	public Set<CoinSensor> getCoinSensors() {
		return this.coinSensors;
	}

	public void setCoinSensors(Set<CoinSensor> coinSensors) {
		this.coinSensors = coinSensors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restroom")
	public Set<ElectricBill> getElectricBills() {
		return this.electricBills;
	}

	public void setElectricBills(Set<ElectricBill> electricBills) {
		this.electricBills = electricBills;
	}
	
	//@ManyToMany relationship 
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "restrooms")
	public Set<Solar> getSolars() {
		return solars;
	}

	public void setSolars(Set<Solar> solars) {
		this.solars = solars;
	}
	
	//---------------------
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restroom")
	public Set<WaterBill> getWaterBills() {
		return this.waterBills;
	}


	public void setWaterBills(Set<WaterBill> waterBills) {
		this.waterBills = waterBills;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restroom")
	public Set<DoorSensor> getDoorSensors() {
		return this.doorSensors;
	}

	public void setDoorSensors(Set<DoorSensor> doorSensors) {
		this.doorSensors = doorSensors;
	}

	@Override
	public String toString() {
		return "restroomId: " + restroomId +
				", address: " + address.toString() +
				", serialNo: " + serialNo +
				", modelNo: " + modelNo +
				", dateInstalled: " + dateInstalled +
				", totalCostOfProduction: $" + totalCostOfProduction +
				", totalCostOfInstallation: $" + totalCostOfInstallation;
	}
}
