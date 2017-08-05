package com.louis.exercise.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.exercise.db.dao.User;
import com.louis.exercise.db.mybatis.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<User> getUsers() {
		return userMapper.getUser();
	}
}
