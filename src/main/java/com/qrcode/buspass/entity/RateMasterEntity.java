package com.qrcode.buspass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "rate_master", schema = "public")
public class RateMasterEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rate_id")
	private Integer rateId;
	@Column(name = "source_id")
	private Integer sourceId;
	@Column(name = "destination_id")
	private Integer destinationId;
	@Column(name = "fare")
	private Double fare;
	@Transient
	private String destinationName;
	@Transient
	private String sourceName;
	public Integer getRateId() {
		return rateId;
	}
	public void setRateId(Integer rateId) {
		this.rateId = rateId;
	}
	
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	public Integer getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "RateMasterEntity [rateId=" + rateId + ", sourceId=" + sourceId + ", destinationId=" + destinationId
				+ ", fare=" + fare + ", destinationName=" + destinationName + ", sourceName=" + sourceName + "]";
	}
	
}
