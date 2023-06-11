package com.qrcode.buspass.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrcode.buspass.Repo.RateMasterRepo;
import com.qrcode.buspass.entity.DestinationMasterEntity;
import com.qrcode.buspass.entity.RateMasterEntity;
import com.qrcode.buspass.entity.SourceMastereEntity;

@Service
@Transactional
public class RateMasterServiceImpl implements RateMasterService {
	@Autowired
	RateMasterRepo rateMasterRepo;
	@Override
	public Integer save(RateMasterEntity rateMasterEntity) {
		// TODO Auto-generated method stub
		return rateMasterRepo.save(rateMasterEntity);
	}
	@Override
	public List<SourceMastereEntity> fetchAllSource() {
		// TODO Auto-generated method stub
		return rateMasterRepo.fetchAllSource();
	}
	@Override
	public List<DestinationMasterEntity> fetAllDestination() {
		// TODO Auto-generated method stub
		return rateMasterRepo.fetAllDestination();
	}

	public Integer findSouDesfare(Integer source, Integer dest) {
	Integer count=rateMasterRepo.findSouDesfare(source,dest);
		return count;
	}
	@Override
	public List<Object[]> fetchAllRate() {
	
		return rateMasterRepo.fetchAllRate();
	}
	@Override
	public void deleteRate(Integer rateId) {
		rateMasterRepo.deleteRate(rateId);
	}
	@Override
	public RateMasterEntity getRateDetails(Integer rateId) {
		
		return rateMasterRepo.getRateDetails(rateId);
	}
	
	public void updateRatedetails(RateMasterEntity rateMasterEntity) {
	
		rateMasterRepo.updateRatedetails(rateMasterEntity);
	}
	
}
