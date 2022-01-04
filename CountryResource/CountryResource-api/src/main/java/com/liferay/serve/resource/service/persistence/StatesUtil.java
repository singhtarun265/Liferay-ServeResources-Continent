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
import com.liferay.serve.resource.model.States;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the states service. This utility wraps <code>com.liferay.serve.resource.service.persistence.impl.StatesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatesPersistence
 * @generated
 */
public class StatesUtil {

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
	public static void clearCache(States states) {
		getPersistence().clearCache(states);
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
	public static Map<Serializable, States> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<States> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<States> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<States> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<States> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static States update(States states) {
		return getPersistence().update(states);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static States update(States states, ServiceContext serviceContext) {
		return getPersistence().update(states, serviceContext);
	}

	/**
	 * Returns all the stateses where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @return the matching stateses
	 */
	public static List<States> findByCountryCode(String countryCode) {
		return getPersistence().findByCountryCode(countryCode);
	}

	/**
	 * Returns a range of all the stateses where countryCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatesModelImpl</code>.
	 * </p>
	 *
	 * @param countryCode the country code
	 * @param start the lower bound of the range of stateses
	 * @param end the upper bound of the range of stateses (not inclusive)
	 * @return the range of matching stateses
	 */
	public static List<States> findByCountryCode(
		String countryCode, int start, int end) {

		return getPersistence().findByCountryCode(countryCode, start, end);
	}

	/**
	 * Returns an ordered range of all the stateses where countryCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatesModelImpl</code>.
	 * </p>
	 *
	 * @param countryCode the country code
	 * @param start the lower bound of the range of stateses
	 * @param end the upper bound of the range of stateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stateses
	 */
	public static List<States> findByCountryCode(
		String countryCode, int start, int end,
		OrderByComparator<States> orderByComparator) {

		return getPersistence().findByCountryCode(
			countryCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stateses where countryCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatesModelImpl</code>.
	 * </p>
	 *
	 * @param countryCode the country code
	 * @param start the lower bound of the range of stateses
	 * @param end the upper bound of the range of stateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stateses
	 */
	public static List<States> findByCountryCode(
		String countryCode, int start, int end,
		OrderByComparator<States> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCountryCode(
			countryCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first states in the ordered set where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching states
	 * @throws NoSuchStatesException if a matching states could not be found
	 */
	public static States findByCountryCode_First(
			String countryCode, OrderByComparator<States> orderByComparator)
		throws com.liferay.serve.resource.exception.NoSuchStatesException {

		return getPersistence().findByCountryCode_First(
			countryCode, orderByComparator);
	}

	/**
	 * Returns the first states in the ordered set where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching states, or <code>null</code> if a matching states could not be found
	 */
	public static States fetchByCountryCode_First(
		String countryCode, OrderByComparator<States> orderByComparator) {

		return getPersistence().fetchByCountryCode_First(
			countryCode, orderByComparator);
	}

	/**
	 * Returns the last states in the ordered set where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching states
	 * @throws NoSuchStatesException if a matching states could not be found
	 */
	public static States findByCountryCode_Last(
			String countryCode, OrderByComparator<States> orderByComparator)
		throws com.liferay.serve.resource.exception.NoSuchStatesException {

		return getPersistence().findByCountryCode_Last(
			countryCode, orderByComparator);
	}

	/**
	 * Returns the last states in the ordered set where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching states, or <code>null</code> if a matching states could not be found
	 */
	public static States fetchByCountryCode_Last(
		String countryCode, OrderByComparator<States> orderByComparator) {

		return getPersistence().fetchByCountryCode_Last(
			countryCode, orderByComparator);
	}

	/**
	 * Returns the stateses before and after the current states in the ordered set where countryCode = &#63;.
	 *
	 * @param stateAbbrev the primary key of the current states
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next states
	 * @throws NoSuchStatesException if a states with the primary key could not be found
	 */
	public static States[] findByCountryCode_PrevAndNext(
			String stateAbbrev, String countryCode,
			OrderByComparator<States> orderByComparator)
		throws com.liferay.serve.resource.exception.NoSuchStatesException {

		return getPersistence().findByCountryCode_PrevAndNext(
			stateAbbrev, countryCode, orderByComparator);
	}

	/**
	 * Removes all the stateses where countryCode = &#63; from the database.
	 *
	 * @param countryCode the country code
	 */
	public static void removeByCountryCode(String countryCode) {
		getPersistence().removeByCountryCode(countryCode);
	}

	/**
	 * Returns the number of stateses where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @return the number of matching stateses
	 */
	public static int countByCountryCode(String countryCode) {
		return getPersistence().countByCountryCode(countryCode);
	}

	/**
	 * Caches the states in the entity cache if it is enabled.
	 *
	 * @param states the states
	 */
	public static void cacheResult(States states) {
		getPersistence().cacheResult(states);
	}

	/**
	 * Caches the stateses in the entity cache if it is enabled.
	 *
	 * @param stateses the stateses
	 */
	public static void cacheResult(List<States> stateses) {
		getPersistence().cacheResult(stateses);
	}

	/**
	 * Creates a new states with the primary key. Does not add the states to the database.
	 *
	 * @param stateAbbrev the primary key for the new states
	 * @return the new states
	 */
	public static States create(String stateAbbrev) {
		return getPersistence().create(stateAbbrev);
	}

	/**
	 * Removes the states with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateAbbrev the primary key of the states
	 * @return the states that was removed
	 * @throws NoSuchStatesException if a states with the primary key could not be found
	 */
	public static States remove(String stateAbbrev)
		throws com.liferay.serve.resource.exception.NoSuchStatesException {

		return getPersistence().remove(stateAbbrev);
	}

	public static States updateImpl(States states) {
		return getPersistence().updateImpl(states);
	}

	/**
	 * Returns the states with the primary key or throws a <code>NoSuchStatesException</code> if it could not be found.
	 *
	 * @param stateAbbrev the primary key of the states
	 * @return the states
	 * @throws NoSuchStatesException if a states with the primary key could not be found
	 */
	public static States findByPrimaryKey(String stateAbbrev)
		throws com.liferay.serve.resource.exception.NoSuchStatesException {

		return getPersistence().findByPrimaryKey(stateAbbrev);
	}

	/**
	 * Returns the states with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateAbbrev the primary key of the states
	 * @return the states, or <code>null</code> if a states with the primary key could not be found
	 */
	public static States fetchByPrimaryKey(String stateAbbrev) {
		return getPersistence().fetchByPrimaryKey(stateAbbrev);
	}

	/**
	 * Returns all the stateses.
	 *
	 * @return the stateses
	 */
	public static List<States> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the stateses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stateses
	 * @param end the upper bound of the range of stateses (not inclusive)
	 * @return the range of stateses
	 */
	public static List<States> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the stateses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stateses
	 * @param end the upper bound of the range of stateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stateses
	 */
	public static List<States> findAll(
		int start, int end, OrderByComparator<States> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stateses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StatesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stateses
	 * @param end the upper bound of the range of stateses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of stateses
	 */
	public static List<States> findAll(
		int start, int end, OrderByComparator<States> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the stateses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of stateses.
	 *
	 * @return the number of stateses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StatesPersistence getPersistence() {
		return _persistence;
	}

	private static volatile StatesPersistence _persistence;

}