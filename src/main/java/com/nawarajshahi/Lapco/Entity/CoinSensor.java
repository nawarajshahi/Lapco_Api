package com.nawarajshahi.Lapco.Entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "coin_sensor", catalog = "lapco_api")
public class CoinSensor{

	private Long readId;
	private Restroom restroom;
	private String sensorId;
	private LocalDateTime readDatetime;
	private Integer noOfQuarters;
	private String message;

	public CoinSensor() {
	}

	public CoinSensor(Long readId, Restroom restroom, String sensorId, LocalDateTime readDatetime, Integer noOfQuarters,
			String message) {
		super();
		this.readId = readId;
		this.restroom = restroom;
		this.sensorId = sensorId;
		this.readDatetime = readDatetime;
		this.noOfQuarters = noOfQuarters;
		this.message = message;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restroom_id")
	public Restroom getRestroom() {
		return this.restroom;
	}

	public void setRestroom(Restroom restroom) {
		this.restroom = restroom;
	}

	@Column(name = "sensor_id", length = 10)
	public String getSensorId() {
		return this.sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}


	@Column(name = "read_datetime", length = 19)
	public LocalDateTime getReadDatetime() {
		return this.readDatetime;
	}

	public void setReadDatetime(LocalDateTime readDatetime) {
		this.readDatetime = readDatetime;
	}

	@Column(name = "NoOfQuarters")
	public Integer getNoOfQuarters() {
		return this.noOfQuarters;
	}

	public void setNoOfQuarters(Integer noOfQuarters) {
		this.noOfQuarters = noOfQuarters;
	}

	@Column(name = "message", length = 200)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
