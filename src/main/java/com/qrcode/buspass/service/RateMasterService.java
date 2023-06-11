package com.qrcode.buspass.service;

import java.util.List;

import com.qrcode.buspass.entity.DestinationMasterEntity;
import com.qrcode.buspass.entity.RateMasterEntity;
import com.qrcode.buspass.entity.SourceMastereEntity;


public interface RateMasterService {

	Integer save(RateMasterEntity rateMasterEntity);

	List<SourceMastereEntity> fetchAllSource();

	List<DestinationMasterEntity> fetAllDestination();
	Integer findSouDesfare(Integer source,Integer dest);
	
	List<Object[]> fetchAllRate();

	void deleteRate(Integer sourceId);

	RateMasterEntity getRateDetails(Integer rateId);

	void updateRatedetails(RateMasterEntity rateMasterEntity);

	
}
