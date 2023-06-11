package com.qrcode.buspass;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.qrcode.buspass.entity.UserEntity;

@Repository
public class UserRepoImpl implements UserRepo {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public int createUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		return (int) session.save(userEntity);
	}

}
