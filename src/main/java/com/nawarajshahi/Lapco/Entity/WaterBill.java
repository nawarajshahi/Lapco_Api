package com.nawarajshahi.Lapco.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "water_bill", catalog = "lapco_api")
public class WaterBill {

	@JsonIgnore
	private Long billId;
	@JsonIgnore
	private Restroom restroom;
	private Date billDate;
	@JsonIgnore
	private Double usedQty;
	@JsonIgnore
	private Double totalCost;

	public WaterBill() {
	}

	
	public WaterBill(Long billId, Restroom restroom, Date billDate, Double usedQty, Double totalCost) {
		super();
		this.billId = billId;
		this.restroom = restroom;
		this.billDate = billDate;
		this.usedQty = usedQty;
		this.totalCost = totalCost;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "bill_id", unique = true, nullable = false)
	public Long getBillId() {
		return this.billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restroom_id")
	public Restroom getRestroom() {
		return this.restroom;
	}

	public void setRestroom(Restroom restroom) {
		this.restroom = restroom;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bill_date", length = 19)
	public Date getBillDate() {
		return this.billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	@Column(name = "used_qty", precision = 22, scale = 0)
	public Double getUsedQty() {
		return this.usedQty;
	}

	public void setUsedQty(Double usedQty) {
		this.usedQty = usedQty;
	}

	@Column(name = "total_cost", precision = 22, scale = 0)
	public Double getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "billId: " + billId +
				", restroomId: " + restroom.getRestroomId() +
				", billDate: " + billDate +
				", usedQty: " + Math.round(usedQty*100.00)/100.0 + "GL" +
				", totalCost: $" + Math.round(totalCost*100.0)/100.0;
	}
}
