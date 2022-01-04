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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.serve.resource.exception.NoSuchStatesException;
import com.liferay.serve.resource.model.States;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the states service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatesUtil
 * @generated
 */
@ProviderType
public interface StatesPersistence extends BasePersistence<States> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatesUtil} to access the states persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the stateses where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @return the matching stateses
	 */
	public java.util.List<States> findByCountryCode(String countryCode);

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
	public java.util.List<States> findByCountryCode(
		String countryCode, int start, int end);

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
	public java.util.List<States> findByCountryCode(
		String countryCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<States>
			orderByComparator);

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
	public java.util.List<States> findByCountryCode(
		String countryCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<States>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first states in the ordered set where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching states
	 * @throws NoSuchStatesException if a matching states could not be found
	 */
	public States findByCountryCode_First(
			String countryCode,
			com.liferay.portal.kernel.util.OrderByComparator<States>
				orderByComparator)
		throws NoSuchStatesException;

	/**
	 * Returns the first states in the ordered set where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching states, or <code>null</code> if a matching states could not be found
	 */
	public States fetchByCountryCode_First(
		String countryCode,
		com.liferay.portal.kernel.util.OrderByComparator<States>
			orderByComparator);

	/**
	 * Returns the last states in the ordered set where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching states
	 * @throws NoSuchStatesException if a matching states could not be found
	 */
	public States findByCountryCode_Last(
			String countryCode,
			com.liferay.portal.kernel.util.OrderByComparator<States>
				orderByComparator)
		throws NoSuchStatesException;

	/**
	 * Returns the last states in the ordered set where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching states, or <code>null</code> if a matching states could not be found
	 */
	public States fetchByCountryCode_Last(
		String countryCode,
		com.liferay.portal.kernel.util.OrderByComparator<States>
			orderByComparator);

	/**
	 * Returns the stateses before and after the current states in the ordered set where countryCode = &#63;.
	 *
	 * @param stateAbbrev the primary key of the current states
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next states
	 * @throws NoSuchStatesException if a states with the primary key could not be found
	 */
	public States[] findByCountryCode_PrevAndNext(
			String stateAbbrev, String countryCode,
			com.liferay.portal.kernel.util.OrderByComparator<States>
				orderByComparator)
		throws NoSuchStatesException;

	/**
	 * Removes all the stateses where countryCode = &#63; from the database.
	 *
	 * @param countryCode the country code
	 */
	public void removeByCountryCode(String countryCode);

	/**
	 * Returns the number of stateses where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @return the number of matching stateses
	 */
	public int countByCountryCode(String countryCode);

	/**
	 * Caches the states in the entity cache if it is enabled.
	 *
	 * @param states the states
	 */
	public void cacheResult(States states);

	/**
	 * Caches the stateses in the entity cache if it is enabled.
	 *
	 * @param stateses the stateses
	 */
	public void cacheResult(java.util.List<States> stateses);

	/**
	 * Creates a new states with the primary key. Does not add the states to the database.
	 *
	 * @param stateAbbrev the primary key for the new states
	 * @return the new states
	 */
	public States create(String stateAbbrev);

	/**
	 * Removes the states with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateAbbrev the primary key of the states
	 * @return the states that was removed
	 * @throws NoSuchStatesException if a states with the primary key could not be found
	 */
	public States remove(String stateAbbrev) throws NoSuchStatesException;

	public States updateImpl(States states);

	/**
	 * Returns the states with the primary key or throws a <code>NoSuchStatesException</code> if it could not be found.
	 *
	 * @param stateAbbrev the primary key of the states
	 * @return the states
	 * @throws NoSuchStatesException if a states with the primary key could not be found
	 */
	public States findByPrimaryKey(String stateAbbrev)
		throws NoSuchStatesException;

	/**
	 * Returns the states with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateAbbrev the primary key of the states
	 * @return the states, or <code>null</code> if a states with the primary key could not be found
	 */
	public States fetchByPrimaryKey(String stateAbbrev);

	/**
	 * Returns all the stateses.
	 *
	 * @return the stateses
	 */
	public java.util.List<States> findAll();

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
	public java.util.List<States> findAll(int start, int end);

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
	public java.util.List<States> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<States>
			orderByComparator);

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
	public java.util.List<States> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<States>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the stateses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of stateses.
	 *
	 * @return the number of stateses
	 */
	public int countAll();

}