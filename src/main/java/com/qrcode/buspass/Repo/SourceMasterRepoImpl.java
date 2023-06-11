package com.qrcode.buspass.Repo;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.qrcode.buspass.entity.SourceMastereEntity;

@Repository
public class SourceMasterRepoImpl implements SourceMasterRepo{
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Integer save(SourceMastereEntity sourceMastereEntity) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		return (Integer) session.save(sourceMastereEntity);
	}
	
	public Integer findBysourceName(String source) {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "From SourceMastereEntity as t where t.sourceName='"+source+"'";
		Query query = currentSession.createQuery(hql);
		return query.getResultList().size();
	}


	public List<SourceMastereEntity> getSourceList() {
		Session currentSession = entityManager.unwrap(Session.class);
		String sList = "From SourceMastereEntity as t";
		Query query = currentSession.createQuery(sList);
		return query.list();
	}

	@Override
	public void deleteSource(Integer sourceId) {
		Session currentSession = entityManager.unwrap(Session.class);
		SourceMastereEntity sourceMastereEntity=currentSession.find(SourceMastereEntity.class, sourceId);
		currentSession.remove(sourceMastereEntity);
	}

	public SourceMastereEntity getSourceDetails(Integer sourceId) {
		Session currentSession = entityManager.unwrap(Session.class);
		SourceMastereEntity sourceMastereEntity=currentSession.find(SourceMastereEntity.class, sourceId);
		return sourceMastereEntity;
	}

	@Override
	public void updateSourcedetails(SourceMastereEntity sourceMastereEntity) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.update(sourceMastereEntity);
		
	}

}
