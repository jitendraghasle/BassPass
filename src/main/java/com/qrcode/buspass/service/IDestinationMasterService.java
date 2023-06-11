package com.qrcode.buspass.service;

import java.util.List;

import com.qrcode.buspass.entity.DestinationMasterEntity;

public interface IDestinationMasterService {

	DestinationMasterEntity getDestination(Integer destinationId);

	List<DestinationMasterEntity> getDestination();

	Integer getDestination(String destinationName);

	Integer save(DestinationMasterEntity destinationMasterEntity);

	void deleteDestination(Integer destinationId);

	void updateDestiontiondetails(DestinationMasterEntity destinationMasterEntity);
	
}
