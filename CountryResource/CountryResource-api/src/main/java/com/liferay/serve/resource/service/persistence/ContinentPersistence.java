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
import com.liferay.serve.resource.exception.NoSuchContinentException;
import com.liferay.serve.resource.model.Continent;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the continent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContinentUtil
 * @generated
 */
@ProviderType
public interface ContinentPersistence extends BasePersistence<Continent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContinentUtil} to access the continent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the continent in the entity cache if it is enabled.
	 *
	 * @param continent the continent
	 */
	public void cacheResult(Continent continent);

	/**
	 * Caches the continents in the entity cache if it is enabled.
	 *
	 * @param continents the continents
	 */
	public void cacheResult(java.util.List<Continent> continents);

	/**
	 * Creates a new continent with the primary key. Does not add the continent to the database.
	 *
	 * @param continentCode the primary key for the new continent
	 * @return the new continent
	 */
	public Continent create(String continentCode);

	/**
	 * Removes the continent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param continentCode the primary key of the continent
	 * @return the continent that was removed
	 * @throws NoSuchContinentException if a continent with the primary key could not be found
	 */
	public Continent remove(String continentCode)
		throws NoSuchContinentException;

	public Continent updateImpl(Continent continent);

	/**
	 * Returns the continent with the primary key or throws a <code>NoSuchContinentException</code> if it could not be found.
	 *
	 * @param continentCode the primary key of the continent
	 * @return the continent
	 * @throws NoSuchContinentException if a continent with the primary key could not be found
	 */
	public Continent findByPrimaryKey(String continentCode)
		throws NoSuchContinentException;

	/**
	 * Returns the continent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param continentCode the primary key of the continent
	 * @return the continent, or <code>null</code> if a continent with the primary key could not be found
	 */
	public Continent fetchByPrimaryKey(String continentCode);

	/**
	 * Returns all the continents.
	 *
	 * @return the continents
	 */
	public java.util.List<Continent> findAll();

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
	public java.util.List<Continent> findAll(int start, int end);

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
	public java.util.List<Continent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Continent>
			orderByComparator);

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
	public java.util.List<Continent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Continent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the continents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of continents.
	 *
	 * @return the number of continents
	 */
	public int countAll();

}