package com.qrcode.buspass.Repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.qrcode.buspass.entity.DestinationMasterEntity;
import com.qrcode.buspass.entity.RateMasterEntity;
import com.qrcode.buspass.entity.SourceMastereEntity;


@Repository
public class RateMasterRepoImpl implements RateMasterRepo {
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public Integer save(RateMasterEntity rateMasterEntity) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		return (Integer) session.save(rateMasterEntity);
	}
	@Override
	public List<SourceMastereEntity> fetchAllSource() {
			    
		return entityManager.createQuery("From SourceMastereEntity").getResultList();
	}
	@Override
	public List<DestinationMasterEntity> fetAllDestination() {
		// TODO Auto-generated method stub
		return  entityManager.createQuery("From DestinationMasterEntity ").getResultList();
	}
	@Override
	public Integer findSouDesfare(Integer source, Integer dest) {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "From RateMasterEntity as t where t.sourceid="+source+" and t.destinationId"+dest;
		Query query = currentSession.createQuery(hql);
		return query.getResultList().size();
	}
	@Override
	public List<Object[]> fetchAllRate() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		String sList = "select so.source_id,so.source_name,de.destination_id,de.destination_name,ra.rate_id,ra.fare from rate_master ra\r\n"
				+ "INNER join source_master so on ra.source_id=so.source_id\r\n"
				+ "inner join destination_master  de on ra.destination_id=de.destination_id";
		Query query = currentSession.createSQLQuery(sList);
		return query.list();
	
	}
	@Override
	public void deleteRate(Integer rateId) {
		Session currentSession = entityManager.unwrap(Session.class);
		RateMasterEntity rateMasterEntity=currentSession.find(RateMasterEntity.class, rateId);
		currentSession.remove(rateMasterEntity);
	}
	@Override
	public RateMasterEntity getRateDetails(Integer rateId) {
		Session currentSession = entityManager.unwrap(Session.class);
		RateMasterEntity rateMasterEntity=currentSession.find(RateMasterEntity.class, rateId);
		return rateMasterEntity;
	}
	@Override
	public void updateRatedetails(RateMasterEntity rateMasterEntity) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.update(rateMasterEntity);		
	}
	

}
