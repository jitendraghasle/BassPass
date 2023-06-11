package com.qrcode.buspass.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrcode.buspass.entity.SourceMastereEntity;

public interface SourceMasterRepo{

	Integer save(SourceMastereEntity sourceMastereEntity);
	Integer findBysourceName(String source);
	List<SourceMastereEntity> getSourceList();
	void deleteSource(Integer sourceId);
	SourceMastereEntity getSourceDetails(Integer sourceId);
	void updateSourcedetails(SourceMastereEntity sourceMastereEntity);
}
