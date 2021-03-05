package com.nawarajshahi.Lapco.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table
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
