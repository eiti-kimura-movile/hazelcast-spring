package com.movile.cache;

import com.hazelcast.core.IMap;
import com.movile.bean.User;

/**
 * CacheService Class is implementation of ICacheService Interface.
 * 
 * @author onlinetechvision.com
 * @since 27 Nov 2012
 * @version 1.0.0
 * 
 */
public class CacheService implements ICacheService {

	private IMap<String, User> userMap;

	/**
	 * Constructor of CacheService
	 * 
	 * @param IMap
	 *            customerMap
	 * 
	 */
	@SuppressWarnings("unchecked")
	public CacheService(IMap<String, User> userMap) {
		setUserMap(userMap);
		getUserMap().addEntryListener(new CustomerEntryListener(), true);
	}

	/**
	 * Adds Customer entries to cache
	 * 
	 * @param String
	 *            key
	 * @param Customer
	 *            customer
	 * 
	 */
	@Override
	public void addToCache(String key, User user) {
		getUserMap().put(key, user);
	}

	/**
	 * Deletes Customer entries from cache
	 * 
	 * @param String
	 *            key
	 * 
	 */
	@Override
	public void deleteFromCache(String key) {
		getUserMap().remove(key);
	}

	/**
	 * Gets Customer cache
	 * 
	 * @return IMap Coherence named cache
	 */
	@Override
	public IMap<String, User> getCache() {
		return getUserMap();
	}

	public IMap<String, User> getUserMap() {
		return userMap;
	}

	public void setUserMap(IMap<String, User> userMap) {
		this.userMap = userMap;
	}

}