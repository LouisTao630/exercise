package com.louis.exercise.db.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.louis.exercise.db.dao.User;

public interface UserMapper {

	@Select("SELECT First_Name AS firstName,Middle_Name as middleName,Last_Name as lastName,Birth_Date as birthday,Gender as gender,Address as address,City as city FROM user")
	List<User> getUser();

	@Insert("INSERT INTO user(First_Name,Middle_Name,Last_Name,Birth_Date,Gender,Address,City)values(#{firstName},#{middleName},#{lastName},#{birthday},#{gender},#{address},#{city})")
	long addUser(User user);
}
