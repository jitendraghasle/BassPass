package com.qrcode.buspass.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrcode.buspass.Repo.SourceMasterRepo;
import com.qrcode.buspass.entity.SourceMastereEntity;

@Service
@Transactional
public class SourceMasterServiceImpl implements SourceMasterService{
	@Autowired
	SourceMasterRepo sourceMasterRepo;
	@Override
	public Integer save(SourceMastereEntity sourceMastereEntity) {
		// TODO Auto-generated method stub
		
		return sourceMasterRepo.save(sourceMastereEntity);
	}
	@Override
	public Integer getSource(String sourceName) {
		
		return sourceMasterRepo.findBysourceName(sourceName);
	}
	public List<SourceMastereEntity> getSourceList() {
		
		return sourceMasterRepo.getSourceList();
	}

	public void deleteSource(Integer sourceId) {
		sourceMasterRepo.deleteSource(sourceId);
		
	}
	
	public SourceMastereEntity getSourceDetails(Integer sourceId) {
		
		return sourceMasterRepo.getSourceDetails(sourceId);
	}
	public void updateSourcedetails(SourceMastereEntity sourceMastereEntity) {
		sourceMasterRepo.updateSourcedetails(sourceMastereEntity);
	}
}
