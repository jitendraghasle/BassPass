package com.qrcode.buspass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrcode.buspass.Repo.IDestinationMasterRepo;
import com.qrcode.buspass.entity.DestinationMasterEntity;

@Service
public class DestinationMasterServiceImpl implements IDestinationMasterService {
	
	@Autowired
	IDestinationMasterRepo destinationMasterRepo;
	@Override
	public DestinationMasterEntity getDestination(Integer destinationId) {
		
		return destinationMasterRepo.getDestination(destinationId);
	}
	@Override
	public List<DestinationMasterEntity> getDestination() {
		return destinationMasterRepo.getDestination();
	}
	@Override
	public Integer getDestination(String destinationName) {
		// TODO Auto-generated method stub
		return destinationMasterRepo.getDestination(destinationName);
	}
	@Override
	public Integer save(DestinationMasterEntity destinationMasterEntity) {
		
		return destinationMasterRepo.save(destinationMasterEntity);
	}
	@Override
	public void deleteDestination(Integer destinationId) {
		destinationMasterRepo.deleteDestination(destinationId);
		
	}
	@Override
	public void updateDestiontiondetails(DestinationMasterEntity destinationMasterEntity) {
		destinationMasterRepo.updateDestiontiondetails(destinationMasterEntity);
		
	}

}
