package com.qrcode.buspass.Repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.qrcode.buspass.entity.DestinationMasterEntity;
import com.qrcode.buspass.entity.SourceMastereEntity;

@Repository
public class DestinationMasterRepoImpl implements IDestinationMasterRepo {

	
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public DestinationMasterEntity getDestination(Integer destinationId) {
		Session currentSession = entityManager.unwrap(Session.class);
		DestinationMasterEntity destinationMasterEntity=currentSession.find(DestinationMasterEntity.class, destinationId);
		return destinationMasterEntity;
	}
	@Override
	public List<DestinationMasterEntity> getDestination() {
		Session currentSession = entityManager.unwrap(Session.class);
		String sList = "From DestinationMasterEntity as t";
		Query query = currentSession.createQuery(sList);
		return query.list();
	}
	@Override
	public Integer save(DestinationMasterEntity destinationMasterEntity) {
		Session session=entityManager.unwrap(Session.class);
		return (Integer) session.save(destinationMasterEntity);
	}
	@Override
	public Integer getDestination(String destinationName) {
 		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "From DestinationMasterEntity as t where t.destinationName='"+destinationName+"'";
		Query query = currentSession.createQuery(hql);
		
		System.out.println("query.getResultList().size()  "+query.getResultList().size());
		return query.getResultList().size();
	}
	@Override
	public void deleteDestination(Integer destinationId) {
		Session currentSession = entityManager.unwrap(Session.class);
		DestinationMasterEntity destinationMasterEntity=currentSession.find(DestinationMasterEntity.class, destinationId);
		currentSession.remove(destinationMasterEntity);		
	}
	@Override
	public void updateDestiontiondetails(DestinationMasterEntity destinationMasterEntity) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.update(destinationMasterEntity);
	}

	
	
}
