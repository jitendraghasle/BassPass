package com.qrcode.buspass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="destination_master",schema="public")
public class DestinationMasterEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="destination_id")
		private Integer destinationId;
	
	@Column(name="destination_name")
	private String destinationName;

	public Integer getDestinationId() {
		return destinationId;
	}

	public void setDestinationid(Integer destinationId) {
		this.destinationId = destinationId;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	

}
