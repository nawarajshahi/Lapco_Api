package com.nawarajshahi.Lapco.Entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class CoinSensor implements java.io.Serializable {

	/**
	 * serialVersionUID = 8136635256361091471L
	 */
	private static final long serialVersionUID = 8136635256361091471L;

	@JsonIgnore
	private Integer readId;

	@JsonIgnore
	private Restroom restroom;

	private String sensorId;

	@JsonIgnore
	private LocalDateTime readDatetime;

	@JsonIgnore
	private Integer noOfQuarters;

	@JsonIgnore
	private String message;

	public CoinSensor() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "read_id", unique = true, nullable = false)
	public Integer getReadId() {
		return this.readId;
	}

	public void setReadId(Integer readId) {
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


	@Column(name = "read_datetime")
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
				", restroomId=" + restroom.getRestroomId() +
				", sensorId='" + sensorId + '\'' +
				", readDatetime=" + readDatetime +
				", noOfQuarters=" + noOfQuarters +
				", message='" + message + '\'' +
				'}';
	}
}
