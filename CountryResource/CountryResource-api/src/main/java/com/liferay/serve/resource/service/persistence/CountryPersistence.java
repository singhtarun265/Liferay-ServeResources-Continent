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
import com.liferay.serve.resource.exception.NoSuchCountryException;
import com.liferay.serve.resource.model.Country;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CountryUtil
 * @generated
 */
@ProviderType
public interface CountryPersistence extends BasePersistence<Country> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CountryUtil} to access the country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the countries where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @return the matching countries
	 */
	public java.util.List<Country> findByContinentCode(String continentCode);

	/**
	 * Returns a range of all the countries where continentCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CountryModelImpl</code>.
	 * </p>
	 *
	 * @param continentCode the continent code
	 * @param start the lower bound of the range of countries
	 * @param end the upper bound of the range of countries (not inclusive)
	 * @return the range of matching countries
	 */
	public java.util.List<Country> findByContinentCode(
		String continentCode, int start, int end);

	/**
	 * Returns an ordered range of all the countries where continentCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CountryModelImpl</code>.
	 * </p>
	 *
	 * @param continentCode the continent code
	 * @param start the lower bound of the range of countries
	 * @param end the upper bound of the range of countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching countries
	 */
	public java.util.List<Country> findByContinentCode(
		String continentCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Country>
			orderByComparator);

	/**
	 * Returns an ordered range of all the countries where continentCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CountryModelImpl</code>.
	 * </p>
	 *
	 * @param continentCode the continent code
	 * @param start the lower bound of the range of countries
	 * @param end the upper bound of the range of countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching countries
	 */
	public java.util.List<Country> findByContinentCode(
		String continentCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Country>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first country in the ordered set where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching country
	 * @throws NoSuchCountryException if a matching country could not be found
	 */
	public Country findByContinentCode_First(
			String continentCode,
			com.liferay.portal.kernel.util.OrderByComparator<Country>
				orderByComparator)
		throws NoSuchCountryException;

	/**
	 * Returns the first country in the ordered set where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching country, or <code>null</code> if a matching country could not be found
	 */
	public Country fetchByContinentCode_First(
		String continentCode,
		com.liferay.portal.kernel.util.OrderByComparator<Country>
			orderByComparator);

	/**
	 * Returns the last country in the ordered set where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching country
	 * @throws NoSuchCountryException if a matching country could not be found
	 */
	public Country findByContinentCode_Last(
			String continentCode,
			com.liferay.portal.kernel.util.OrderByComparator<Country>
				orderByComparator)
		throws NoSuchCountryException;

	/**
	 * Returns the last country in the ordered set where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching country, or <code>null</code> if a matching country could not be found
	 */
	public Country fetchByContinentCode_Last(
		String continentCode,
		com.liferay.portal.kernel.util.OrderByComparator<Country>
			orderByComparator);

	/**
	 * Returns the countries before and after the current country in the ordered set where continentCode = &#63;.
	 *
	 * @param countryCode the primary key of the current country
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next country
	 * @throws NoSuchCountryException if a country with the primary key could not be found
	 */
	public Country[] findByContinentCode_PrevAndNext(
			String countryCode, String continentCode,
			com.liferay.portal.kernel.util.OrderByComparator<Country>
				orderByComparator)
		throws NoSuchCountryException;

	/**
	 * Removes all the countries where continentCode = &#63; from the database.
	 *
	 * @param continentCode the continent code
	 */
	public void removeByContinentCode(String continentCode);

	/**
	 * Returns the number of countries where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @return the number of matching countries
	 */
	public int countByContinentCode(String continentCode);

	/**
	 * Caches the country in the entity cache if it is enabled.
	 *
	 * @param country the country
	 */
	public void cacheResult(Country country);

	/**
	 * Caches the countries in the entity cache if it is enabled.
	 *
	 * @param countries the countries
	 */
	public void cacheResult(java.util.List<Country> countries);

	/**
	 * Creates a new country with the primary key. Does not add the country to the database.
	 *
	 * @param countryCode the primary key for the new country
	 * @return the new country
	 */
	public Country create(String countryCode);

	/**
	 * Removes the country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param countryCode the primary key of the country
	 * @return the country that was removed
	 * @throws NoSuchCountryException if a country with the primary key could not be found
	 */
	public Country remove(String countryCode) throws NoSuchCountryException;

	public Country updateImpl(Country country);

	/**
	 * Returns the country with the primary key or throws a <code>NoSuchCountryException</code> if it could not be found.
	 *
	 * @param countryCode the primary key of the country
	 * @return the country
	 * @throws NoSuchCountryException if a country with the primary key could not be found
	 */
	public Country findByPrimaryKey(String countryCode)
		throws NoSuchCountryException;

	/**
	 * Returns the country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param countryCode the primary key of the country
	 * @return the country, or <code>null</code> if a country with the primary key could not be found
	 */
	public Country fetchByPrimaryKey(String countryCode);

	/**
	 * Returns all the countries.
	 *
	 * @return the countries
	 */
	public java.util.List<Country> findAll();

	/**
	 * Returns a range of all the countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of countries
	 * @param end the upper bound of the range of countries (not inclusive)
	 * @return the range of countries
	 */
	public java.util.List<Country> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of countries
	 * @param end the upper bound of the range of countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of countries
	 */
	public java.util.List<Country> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Country>
			orderByComparator);

	/**
	 * Returns an ordered range of all the countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CountryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of countries
	 * @param end the upper bound of the range of countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of countries
	 */
	public java.util.List<Country> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Country>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the countries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of countries.
	 *
	 * @return the number of countries
	 */
	public int countAll();

}