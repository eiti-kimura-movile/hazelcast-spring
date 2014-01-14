package com.movile.logic;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import com.movile.bean.User;
import com.movile.cache.ICacheService;
import com.movile.dao.UsersDAO;

public class Application {

	private ICacheService cacheService;

	private final UsersDAO userDB = new UsersDAO();

	private final SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss-SS");

	private long lastChange;

	public Application() {

	}

	/**
	 * A user logs on to the application
	 * 
	 * @param username
	 *            The user name
	 */
	public void logon(String username) {

		User user = userDB.get(username);

		getCacheService().addToCache(username, user);
		lastChange = System.currentTimeMillis();
	}

	/**
	 * The user logs out (or off depending on your pov).
	 */
	public void logout(String username) {

		getCacheService().deleteFromCache(username);
		lastChange = System.currentTimeMillis();
	}

	/**
	 * @return Return true if the user is logged on
	 */
	public boolean isLoggedOn(String username) {
		return getCacheService().getCache().containsKey(username);
	}

	/**
	 * Return a list of the currently logged on users - perhaps to sys admin.
	 */
	public Collection<User> loggedOnUsers() {
		return getCacheService().getCache().values();
	}

	public ICacheService getCacheService() {
		return cacheService;
	}

	public void setCacheService(ICacheService cacheService) {
		this.cacheService = cacheService;
	}

	/**
	 * Display the logged on users
	 */
	public void displayUsers() {

		StringBuilder sb = new StringBuilder("Logged on users:\n");
		Collection<User> users = getCacheService().getCache().values();

		for (User user : users) {
			sb.append(user);
			sb.append("\n");
		}

		sb.append(getCacheService().getCache().size());
		sb.append(" -- ");
		sb.append(sdf.format(new Date(lastChange)));
		sb.append("\n");
		System.out.println(sb.toString());
	}

}