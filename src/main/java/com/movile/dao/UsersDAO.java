package com.movile.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.movile.bean.User;

public class UsersDAO {

	/** The users in the database */
	private final User[] users = {
			new User("fred123", "Fred", "Jones", "fredj@a.com"),
			new User("jim", "Jim", "Jones", "jimj@a.com"),
			new User("bill", "Bill", "Jones", "bill@a.com"),
			new User("ted111", "Edward", "Jones", "tedj@a.com"),
			new User("annie", "Annette", "Jones", "annj@a.com"),
			new User("lucy", "Lucy", "Jones", "lucyj@a.com"),
			new User("jimj", "James", "Jones", "jimj@a.com"),
			new User("jez", "Jerry", "Jones", "fredj@a.com"),
			new User("will", "William", "Jones", "willj@a.com"),
			new User("shaz", "Sharon", "Jones", "shazj@a.com"),
			new User("paula", "Paula", "Jones", "pauj@a.com"),
			new User("leo", "Leonardo", "Jones", "leoj@a.com"),
			new User("ekm", "Eiti", "Kimura", "kimura@a.com"),
			new User("casa", "Casa", "Grande", "casao@a.com"), };

	private final Map<String, User> userMap;

	public UsersDAO() {
		userMap = new HashMap<String, User>();

		for (User user : users) {
			userMap.put(user.getUsername(), user);
		}
	}

	/**
	 * The number of users in the database
	 */
	public int size() {
		return userMap.size();
	}

	/**
	 * Given a number, return the user
	 */
	public User get(int index) {
		return users[index];
	}

	/**
	 * Given the user's name return the User details
	 */
	public User get(String username) {
		return userMap.get(username);
	}

	/**
	 * Return the user names.
	 */
	public Set<String> getUserNames() {
		return userMap.keySet();
	}
}