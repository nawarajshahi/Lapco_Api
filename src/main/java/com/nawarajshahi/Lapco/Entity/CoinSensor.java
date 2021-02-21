package com.nawarajshahi.Lapco.Entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "coin_sensor", catalog = "lapco_api")
public class CoinSensor implements Serializable {

	private Long readId;
	private Restroom restroom;
	private String sensorId;
	private LocalDateTime readDatetime;
	private Integer noOfQuarters;
	private String message;

	public CoinSensor() {
	}

	public CoinSensor(String sensorId, String message) {
		this.sensorId = sensorId;
		this.message = message;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Override
	public String toString() {
		return "CoinSensor{" +
				"readId=" + readId +
				", restroom=" + restroom +
				", sensorId='" + sensorId + '\'' +
				", readDatetime=" + readDatetime +
				", noOfQuarters=" + noOfQuarters +
				", message='" + message + '\'' +
				'}';
	}
}
