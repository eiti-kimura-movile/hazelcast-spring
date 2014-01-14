package com.movile.cache;

import com.hazelcast.core.IMap;
import com.movile.bean.User;

/**
 * A new ICacheService Interface is created for service layer to expose cache
 * functionality.
 */
public interface ICacheService {

	/**
	 * Adds Customer entries to cache
	 * 
	 * @param String
	 *            key
	 * @param Customer
	 *            customer
	 * 
	 */
	void addToCache(String key, User user);

	/**
	 * Deletes Customer entries from cache
	 * 
	 * @param String
	 *            key
	 * 
	 */
	void deleteFromCache(String key);

	/**
	 * Gets Customer cache
	 * 
	 * @return IMap Coherence named cache
	 */
	IMap<String, User> getCache();
}