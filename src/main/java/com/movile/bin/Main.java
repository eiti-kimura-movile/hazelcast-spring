package com.movile.bin;

import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.movile.logic.Application;
import com.movile.logic.BigWideWorld;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		BigWideWorld theWorld = new BigWideWorld();

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		Application application = (Application) context.getBean("application");

		while (true) {

			String username = theWorld.nextUser();

			if (application.isLoggedOn(username)) {
				application.logout(username);
			} else {
				application.logon(username);
			}

			application.displayUsers();
			TimeUnit.SECONDS.sleep(2);
		}
	}

}