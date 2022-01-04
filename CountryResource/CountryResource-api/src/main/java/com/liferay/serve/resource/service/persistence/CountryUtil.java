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
import com.liferay.serve.resource.model.Country;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the country service. This utility wraps <code>com.liferay.serve.resource.service.persistence.impl.CountryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CountryPersistence
 * @generated
 */
public class CountryUtil {

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
	public static void clearCache(Country country) {
		getPersistence().clearCache(country);
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
	public static Map<Serializable, Country> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Country> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Country> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Country> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Country> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Country update(Country country) {
		return getPersistence().update(country);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Country update(
		Country country, ServiceContext serviceContext) {

		return getPersistence().update(country, serviceContext);
	}

	/**
	 * Returns all the countries where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @return the matching countries
	 */
	public static List<Country> findByContinentCode(String continentCode) {
		return getPersistence().findByContinentCode(continentCode);
	}

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
	public static List<Country> findByContinentCode(
		String continentCode, int start, int end) {

		return getPersistence().findByContinentCode(continentCode, start, end);
	}

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
	public static List<Country> findByContinentCode(
		String continentCode, int start, int end,
		OrderByComparator<Country> orderByComparator) {

		return getPersistence().findByContinentCode(
			continentCode, start, end, orderByComparator);
	}

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
	public static List<Country> findByContinentCode(
		String continentCode, int start, int end,
		OrderByComparator<Country> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByContinentCode(
			continentCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first country in the ordered set where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching country
	 * @throws NoSuchCountryException if a matching country could not be found
	 */
	public static Country findByContinentCode_First(
			String continentCode, OrderByComparator<Country> orderByComparator)
		throws com.liferay.serve.resource.exception.NoSuchCountryException {

		return getPersistence().findByContinentCode_First(
			continentCode, orderByComparator);
	}

	/**
	 * Returns the first country in the ordered set where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching country, or <code>null</code> if a matching country could not be found
	 */
	public static Country fetchByContinentCode_First(
		String continentCode, OrderByComparator<Country> orderByComparator) {

		return getPersistence().fetchByContinentCode_First(
			continentCode, orderByComparator);
	}

	/**
	 * Returns the last country in the ordered set where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching country
	 * @throws NoSuchCountryException if a matching country could not be found
	 */
	public static Country findByContinentCode_Last(
			String continentCode, OrderByComparator<Country> orderByComparator)
		throws com.liferay.serve.resource.exception.NoSuchCountryException {

		return getPersistence().findByContinentCode_Last(
			continentCode, orderByComparator);
	}

	/**
	 * Returns the last country in the ordered set where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching country, or <code>null</code> if a matching country could not be found
	 */
	public static Country fetchByContinentCode_Last(
		String continentCode, OrderByComparator<Country> orderByComparator) {

		return getPersistence().fetchByContinentCode_Last(
			continentCode, orderByComparator);
	}

	/**
	 * Returns the countries before and after the current country in the ordered set where continentCode = &#63;.
	 *
	 * @param countryCode the primary key of the current country
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next country
	 * @throws NoSuchCountryException if a country with the primary key could not be found
	 */
	public static Country[] findByContinentCode_PrevAndNext(
			String countryCode, String continentCode,
			OrderByComparator<Country> orderByComparator)
		throws com.liferay.serve.resource.exception.NoSuchCountryException {

		return getPersistence().findByContinentCode_PrevAndNext(
			countryCode, continentCode, orderByComparator);
	}

	/**
	 * Removes all the countries where continentCode = &#63; from the database.
	 *
	 * @param continentCode the continent code
	 */
	public static void removeByContinentCode(String continentCode) {
		getPersistence().removeByContinentCode(continentCode);
	}

	/**
	 * Returns the number of countries where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @return the number of matching countries
	 */
	public static int countByContinentCode(String continentCode) {
		return getPersistence().countByContinentCode(continentCode);
	}

	/**
	 * Caches the country in the entity cache if it is enabled.
	 *
	 * @param country the country
	 */
	public static void cacheResult(Country country) {
		getPersistence().cacheResult(country);
	}

	/**
	 * Caches the countries in the entity cache if it is enabled.
	 *
	 * @param countries the countries
	 */
	public static void cacheResult(List<Country> countries) {
		getPersistence().cacheResult(countries);
	}

	/**
	 * Creates a new country with the primary key. Does not add the country to the database.
	 *
	 * @param countryCode the primary key for the new country
	 * @return the new country
	 */
	public static Country create(String countryCode) {
		return getPersistence().create(countryCode);
	}

	/**
	 * Removes the country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param countryCode the primary key of the country
	 * @return the country that was removed
	 * @throws NoSuchCountryException if a country with the primary key could not be found
	 */
	public static Country remove(String countryCode)
		throws com.liferay.serve.resource.exception.NoSuchCountryException {

		return getPersistence().remove(countryCode);
	}

	public static Country updateImpl(Country country) {
		return getPersistence().updateImpl(country);
	}

	/**
	 * Returns the country with the primary key or throws a <code>NoSuchCountryException</code> if it could not be found.
	 *
	 * @param countryCode the primary key of the country
	 * @return the country
	 * @throws NoSuchCountryException if a country with the primary key could not be found
	 */
	public static Country findByPrimaryKey(String countryCode)
		throws com.liferay.serve.resource.exception.NoSuchCountryException {

		return getPersistence().findByPrimaryKey(countryCode);
	}

	/**
	 * Returns the country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param countryCode the primary key of the country
	 * @return the country, or <code>null</code> if a country with the primary key could not be found
	 */
	public static Country fetchByPrimaryKey(String countryCode) {
		return getPersistence().fetchByPrimaryKey(countryCode);
	}

	/**
	 * Returns all the countries.
	 *
	 * @return the countries
	 */
	public static List<Country> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Country> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Country> findAll(
		int start, int end, OrderByComparator<Country> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Country> findAll(
		int start, int end, OrderByComparator<Country> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the countries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of countries.
	 *
	 * @return the number of countries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CountryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CountryPersistence _persistence;

}