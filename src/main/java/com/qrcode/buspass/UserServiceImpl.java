package com.qrcode.buspass;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrcode.buspass.entity.UserEntity;

@Service
@Transactional
public class UserServiceImpl implements UserService {


	@Autowired
	UserRepo userRepo;
	
	@Override
	public int createUser(UserEntity userEntity) {
		return userRepo.createUser(userEntity);
	}

}
