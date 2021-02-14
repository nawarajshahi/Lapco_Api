package com.nawarajshahi.Lapco.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "restroom", catalog = "lapco_api")
public class Restroom {

	private Long restroomId;
	private Address address;
	private String serialNo;
	private String modelNo;
	private Date dateInstalled;
	private Double totalCostOfProduction;
	private Double totalCostOfInstallation;
	private Set<CoinSensor> coinSensors = new HashSet<CoinSensor>(0);
	private Set<ElectricBill> electricBills = new HashSet<ElectricBill>(0);
	
	private Set<WaterBill> waterBills = new HashSet<WaterBill>(0);
	private Set<DoorSensor> doorSensors = new HashSet<DoorSensor>(0);
	
	private Set<Solar> solars = new HashSet<Solar>(0);

	public Restroom() {
	}

	public Restroom(Long restroomId, Address address, String serialNo, String modelNo, Date dateInstalled,
			Double totalCostOfProduction, Double totalCostOfInstallation, Set<CoinSensor> coinSensors,
			Set<ElectricBill> electricBills, Set<WaterBill> waterBills, Set<DoorSensor> doorSensors,
			Set<Solar> solars) {
		super();
		this.restroomId = restroomId;
		this.address = address;
		this.serialNo = serialNo;
		this.modelNo = modelNo;
		this.dateInstalled = dateInstalled;
		this.totalCostOfProduction = totalCostOfProduction;
		this.totalCostOfInstallation = totalCostOfInstallation;
		this.coinSensors = coinSensors;
		this.electricBills = electricBills;
		this.waterBills = waterBills;
		this.doorSensors = doorSensors;
		this.solars = solars;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "restroom_id", unique = true, nullable = false)
	public Long getRestroomId() {
		return this.restroomId;
	}

	public void setRestroomId(Long restroomId) {
		this.restroomId = restroomId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
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

}
