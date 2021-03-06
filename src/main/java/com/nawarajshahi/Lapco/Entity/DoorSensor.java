package com.nawarajshahi.Lapco.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class DoorSensor {


	private Long readId;
	@JsonIgnore
	private Restroom restroom;
	private String doorId;

	private LocalDateTime doorOpenTime;

	private LocalDateTime doorCloseTime;

	private String message;

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

	@Column(name = "door_id", length = 10)
	public String getDoorId() {
		return this.doorId;
	}

	public void setDoorId(String doorId) {
		this.doorId = doorId;
	}

	
	@Column(name = "doorOpenTime", length = 19)
	public LocalDateTime getDoorOpenTime() {
		return this.doorOpenTime;
	}

	public void setDoorOpenTime(LocalDateTime doorOpenTime) {
		this.doorOpenTime = doorOpenTime;
	}

	
	@Column(name = "doorCloseTime", length = 19)
	public LocalDateTime getDoorCloseTime() {
		return this.doorCloseTime;
	}

	public void setDoorCloseTime(LocalDateTime doorCloseTime) {
		this.doorCloseTime = doorCloseTime;
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
		return "readId: " + readId +
				", restroom: " + restroom.getRestroomId() +
				", doorId: " + doorId +
				", doorOpenTime: " + doorOpenTime +
				", doorCloseTime: " + doorCloseTime +
				", message: '" + message + '\'';
	}
}
