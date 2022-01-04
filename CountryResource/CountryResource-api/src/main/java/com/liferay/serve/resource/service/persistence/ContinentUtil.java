/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.serve.resource.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.serve.resource.model.Continent;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the continent service. This utility wraps <code>com.liferay.serve.resource.service.persistence.impl.ContinentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContinentPersistence
 * @generated
 */
public class ContinentUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Continent continent) {
		getPersistence().clearCache(continent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Continent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Continent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Continent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Continent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Continent> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Continent update(Continent continent) {
		return getPersistence().update(continent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Continent update(
		Continent continent, ServiceContext serviceContext) {

		return getPersistence().update(continent, serviceContext);
	}

	/**
	 * Caches the continent in the entity cache if it is enabled.
	 *
	 * @param continent the continent
	 */
	public static void cacheResult(Continent continent) {
		getPersistence().cacheResult(continent);
	}

	/**
	 * Caches the continents in the entity cache if it is enabled.
	 *
	 * @param continents the continents
	 */
	public static void cacheResult(List<Continent> continents) {
		getPersistence().cacheResult(continents);
	}

	/**
	 * Creates a new continent with the primary key. Does not add the continent to the database.
	 *
	 * @param continentCode the primary key for the new continent
	 * @return the new continent
	 */
	public static Continent create(String continentCode) {
		return getPersistence().create(continentCode);
	}

	/**
	 * Removes the continent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param continentCode the primary key of the continent
	 * @return the continent that was removed
	 * @throws NoSuchContinentException if a continent with the primary key could not be found
	 */
	public static Continent remove(String continentCode)
		throws com.liferay.serve.resource.exception.NoSuchContinentException {

		return getPersistence().remove(continentCode);
	}

	public static Continent updateImpl(Continent continent) {
		return getPersistence().updateImpl(continent);
	}

	/**
	 * Returns the continent with the primary key or throws a <code>NoSuchContinentException</code> if it could not be found.
	 *
	 * @param continentCode the primary key of the continent
	 * @return the continent
	 * @throws NoSuchContinentException if a continent with the primary key could not be found
	 */
	public static Continent findByPrimaryKey(String continentCode)
		throws com.liferay.serve.resource.exception.NoSuchContinentException {

		return getPersistence().findByPrimaryKey(continentCode);
	}

	/**
	 * Returns the continent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param continentCode the primary key of the continent
	 * @return the continent, or <code>null</code> if a continent with the primary key could not be found
	 */
	public static Continent fetchByPrimaryKey(String continentCode) {
		return getPersistence().fetchByPrimaryKey(continentCode);
	}

	/**
	 * Returns all the continents.
	 *
	 * @return the continents
	 */
	public static List<Continent> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the continents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContinentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of continents
	 * @param end the upper bound of the range of continents (not inclusive)
	 * @return the range of continents
	 */
	public static List<Continent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the continents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContinentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of continents
	 * @param end the upper bound of the range of continents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of continents
	 */
	public static List<Continent> findAll(
		int start, int end, OrderByComparator<Continent> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the continents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContinentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of continents
	 * @param end the upper bound of the range of continents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of continents
	 */
	public static List<Continent> findAll(
		int start, int end, OrderByComparator<Continent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the continents from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of continents.
	 *
	 * @return the number of continents
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ContinentPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ContinentPersistence _persistence;

}