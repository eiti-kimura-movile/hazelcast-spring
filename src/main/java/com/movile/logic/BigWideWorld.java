package com.movile.logic;

import java.util.Random;

import com.movile.bean.User;
import com.movile.dao.UsersDAO;

public class BigWideWorld {

	private static Random rand = new Random(System.currentTimeMillis());

	private final UsersDAO users = new UsersDAO();

	private final int totalNumUsers = users.size();

	public String nextUser() {

		User user = users.get(rand.nextInt(totalNumUsers));
		String name = user.getUsername();

		return name;
	}

}