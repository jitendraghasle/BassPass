package com.qrcode.buspass.Repo;

import java.util.List;

import com.qrcode.buspass.entity.DestinationMasterEntity;

public interface IDestinationMasterRepo {

	DestinationMasterEntity getDestination(Integer destinationId);

	List<DestinationMasterEntity> getDestination();

	Integer save(DestinationMasterEntity destinationMasterEntity);

	Integer getDestination(String destinationName);

	void deleteDestination(Integer destinationId);

	void updateDestiontiondetails(DestinationMasterEntity destinationMasterEntity);

}
