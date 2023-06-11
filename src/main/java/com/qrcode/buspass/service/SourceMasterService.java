package com.qrcode.buspass.service;

import java.util.List;

import com.qrcode.buspass.entity.SourceMastereEntity;

public interface SourceMasterService {

	Integer save(SourceMastereEntity sourceMastereEntity);
	Integer getSource(String sourceName);
	
	List<SourceMastereEntity> getSourceList();
	void deleteSource(Integer sourceId);
	SourceMastereEntity getSourceDetails(Integer sourceId);
	public void updateSourcedetails(SourceMastereEntity sourceMastereEntity);

}
