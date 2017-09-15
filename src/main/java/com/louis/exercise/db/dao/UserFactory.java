package com.louis.exercise.db.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service()
public class UserFactory {

	private static String[] first_names = { "Louis", "Peter", "Mary", "Alice", "Kity", "Tom", "Jarry" };

	private static String[] middle_names = { "I", "F", "G", "" };

	private static String[] last_names = { "Tao", "Li", "Zhang", "Fang", "Sun", "Wang", "Luo" };

	private static String[] gender = { "M", "F" };

	private static String[] cities = { "ShangHai", "HangZhou", "BeiJing", "ShanDong", "ChongQing" };

	private static String[] addresses = { "Shang Hai Street 1", "Chong Qing Street 2", "Shan Xi Street 3" };

	private static String[] years = { "1985", "1986", "1987", "1988" };

	private static String[] monthes = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

	private static String[] days = { "5", "10", "15" };

	public User simulateUser() throws ParseException {
		User user = new User();
		user.setFirstName(getRandomValue(first_names));
		user.setMiddleName(getRandomValue(middle_names));
		user.setLastName(getRandomValue(last_names));
		user.setGender(getRandomValue(gender));
		user.setCity(getRandomValue(cities));
		user.setAddress(getRandomValue(addresses));
		user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(getRandomValue(years) + "-" + getRandomValue(monthes) + "-" + getRandomValue(days)));

		return user;
	}

	private String getRandomValue(String[] objects) {
		Random random = new Random();
		int rand = random.nextInt(objects.length);
		return objects[rand];
	}

}
