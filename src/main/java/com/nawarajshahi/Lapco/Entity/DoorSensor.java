package com.nawarajshahi.Lapco.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "door_sensor", catalog = "lapco_api")
public class DoorSensor implements java.io.Serializable {

	private Integer readId;
	private Restroom restroom;
	private String doorId;
	private Date doorOpenTime;
	private Date doorCloseTime;
	private String message;

	public DoorSensor() {
	}

	public DoorSensor(Restroom restroom, String doorId, Date doorOpenTime, Date doorCloseTime, String message) {
		this.restroom = restroom;
		this.doorId = doorId;
		this.doorOpenTime = doorOpenTime;
		this.doorCloseTime = doorCloseTime;
		this.message = message;
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

	@Column(name = "door_id", length = 10)
	public String getDoorId() {
		return this.doorId;
	}

	public void setDoorId(String doorId) {
		this.doorId = doorId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "doorOpenTime", length = 19)
	public Date getDoorOpenTime() {
		return this.doorOpenTime;
	}

	public void setDoorOpenTime(Date doorOpenTime) {
		this.doorOpenTime = doorOpenTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "doorCloseTime", length = 19)
	public Date getDoorCloseTime() {
		return this.doorCloseTime;
	}

	public void setDoorCloseTime(Date doorCloseTime) {
		this.doorCloseTime = doorCloseTime;
	}

	@Column(name = "message", length = 200)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
