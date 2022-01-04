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

package com.liferay.serve.resource.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.serve.resource.exception.NoSuchCountryException;
import com.liferay.serve.resource.model.Country;
import com.liferay.serve.resource.model.impl.CountryImpl;
import com.liferay.serve.resource.model.impl.CountryModelImpl;
import com.liferay.serve.resource.service.persistence.CountryPersistence;
import com.liferay.serve.resource.service.persistence.CountryUtil;
import com.liferay.serve.resource.service.persistence.impl.constants.FOOPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CountryPersistence.class)
public class CountryPersistenceImpl
	extends BasePersistenceImpl<Country> implements CountryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CountryUtil</code> to access the country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CountryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByContinentCode;
	private FinderPath _finderPathWithoutPaginationFindByContinentCode;
	private FinderPath _finderPathCountByContinentCode;

	/**
	 * Returns all the countries where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @return the matching countries
	 */
	@Override
	public List<Country> findByContinentCode(String continentCode) {
		return findByContinentCode(
			continentCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Country> findByContinentCode(
		String continentCode, int start, int end) {

		return findByContinentCode(continentCode, start, end, null);
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
	@Override
	public List<Country> findByContinentCode(
		String continentCode, int start, int end,
		OrderByComparator<Country> orderByComparator) {

		return findByContinentCode(
			continentCode, start, end, orderByComparator, true);
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
	@Override
	public List<Country> findByContinentCode(
		String continentCode, int start, int end,
		OrderByComparator<Country> orderByComparator, boolean useFinderCache) {

		continentCode = Objects.toString(continentCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByContinentCode;
				finderArgs = new Object[] {continentCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByContinentCode;
			finderArgs = new Object[] {
				continentCode, start, end, orderByComparator
			};
		}

		List<Country> list = null;

		if (useFinderCache) {
			list = (List<Country>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Country country : list) {
					if (!continentCode.equals(country.getContinentCode())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_COUNTRY_WHERE);

			boolean bindContinentCode = false;

			if (continentCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONTINENTCODE_CONTINENTCODE_3);
			}
			else {
				bindContinentCode = true;

				sb.append(_FINDER_COLUMN_CONTINENTCODE_CONTINENTCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindContinentCode) {
					queryPos.add(continentCode);
				}

				list = (List<Country>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first country in the ordered set where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching country
	 * @throws NoSuchCountryException if a matching country could not be found
	 */
	@Override
	public Country findByContinentCode_First(
			String continentCode, OrderByComparator<Country> orderByComparator)
		throws NoSuchCountryException {

		Country country = fetchByContinentCode_First(
			continentCode, orderByComparator);

		if (country != null) {
			return country;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("continentCode=");
		sb.append(continentCode);

		sb.append("}");

		throw new NoSuchCountryException(sb.toString());
	}

	/**
	 * Returns the first country in the ordered set where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching country, or <code>null</code> if a matching country could not be found
	 */
	@Override
	public Country fetchByContinentCode_First(
		String continentCode, OrderByComparator<Country> orderByComparator) {

		List<Country> list = findByContinentCode(
			continentCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last country in the ordered set where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching country
	 * @throws NoSuchCountryException if a matching country could not be found
	 */
	@Override
	public Country findByContinentCode_Last(
			String continentCode, OrderByComparator<Country> orderByComparator)
		throws NoSuchCountryException {

		Country country = fetchByContinentCode_Last(
			continentCode, orderByComparator);

		if (country != null) {
			return country;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("continentCode=");
		sb.append(continentCode);

		sb.append("}");

		throw new NoSuchCountryException(sb.toString());
	}

	/**
	 * Returns the last country in the ordered set where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching country, or <code>null</code> if a matching country could not be found
	 */
	@Override
	public Country fetchByContinentCode_Last(
		String continentCode, OrderByComparator<Country> orderByComparator) {

		int count = countByContinentCode(continentCode);

		if (count == 0) {
			return null;
		}

		List<Country> list = findByContinentCode(
			continentCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Country[] findByContinentCode_PrevAndNext(
			String countryCode, String continentCode,
			OrderByComparator<Country> orderByComparator)
		throws NoSuchCountryException {

		continentCode = Objects.toString(continentCode, "");

		Country country = findByPrimaryKey(countryCode);

		Session session = null;

		try {
			session = openSession();

			Country[] array = new CountryImpl[3];

			array[0] = getByContinentCode_PrevAndNext(
				session, country, continentCode, orderByComparator, true);

			array[1] = country;

			array[2] = getByContinentCode_PrevAndNext(
				session, country, continentCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Country getByContinentCode_PrevAndNext(
		Session session, Country country, String continentCode,
		OrderByComparator<Country> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COUNTRY_WHERE);

		boolean bindContinentCode = false;

		if (continentCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_CONTINENTCODE_CONTINENTCODE_3);
		}
		else {
			bindContinentCode = true;

			sb.append(_FINDER_COLUMN_CONTINENTCODE_CONTINENTCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindContinentCode) {
			queryPos.add(continentCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(country)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Country> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the countries where continentCode = &#63; from the database.
	 *
	 * @param continentCode the continent code
	 */
	@Override
	public void removeByContinentCode(String continentCode) {
		for (Country country :
				findByContinentCode(
					continentCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(country);
		}
	}

	/**
	 * Returns the number of countries where continentCode = &#63;.
	 *
	 * @param continentCode the continent code
	 * @return the number of matching countries
	 */
	@Override
	public int countByContinentCode(String continentCode) {
		continentCode = Objects.toString(continentCode, "");

		FinderPath finderPath = _finderPathCountByContinentCode;

		Object[] finderArgs = new Object[] {continentCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COUNTRY_WHERE);

			boolean bindContinentCode = false;

			if (continentCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONTINENTCODE_CONTINENTCODE_3);
			}
			else {
				bindContinentCode = true;

				sb.append(_FINDER_COLUMN_CONTINENTCODE_CONTINENTCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindContinentCode) {
					queryPos.add(continentCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONTINENTCODE_CONTINENTCODE_2 =
		"country.continentCode = ?";

	private static final String _FINDER_COLUMN_CONTINENTCODE_CONTINENTCODE_3 =
		"(country.continentCode IS NULL OR country.continentCode = '')";

	public CountryPersistenceImpl() {
		setModelClass(Country.class);

		setModelImplClass(CountryImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the country in the entity cache if it is enabled.
	 *
	 * @param country the country
	 */
	@Override
	public void cacheResult(Country country) {
		entityCache.putResult(
			CountryImpl.class, country.getPrimaryKey(), country);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the countries in the entity cache if it is enabled.
	 *
	 * @param countries the countries
	 */
	@Override
	public void cacheResult(List<Country> countries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (countries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Country country : countries) {
			if (entityCache.getResult(
					CountryImpl.class, country.getPrimaryKey()) == null) {

				cacheResult(country);
			}
		}
	}

	/**
	 * Clears the cache for all countries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CountryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the country.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Country country) {
		entityCache.removeResult(CountryImpl.class, country);
	}

	@Override
	public void clearCache(List<Country> countries) {
		for (Country country : countries) {
			entityCache.removeResult(CountryImpl.class, country);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CountryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new country with the primary key. Does not add the country to the database.
	 *
	 * @param countryCode the primary key for the new country
	 * @return the new country
	 */
	@Override
	public Country create(String countryCode) {
		Country country = new CountryImpl();

		country.setNew(true);
		country.setPrimaryKey(countryCode);

		return country;
	}

	/**
	 * Removes the country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param countryCode the primary key of the country
	 * @return the country that was removed
	 * @throws NoSuchCountryException if a country with the primary key could not be found
	 */
	@Override
	public Country remove(String countryCode) throws NoSuchCountryException {
		return remove((Serializable)countryCode);
	}

	/**
	 * Removes the country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the country
	 * @return the country that was removed
	 * @throws NoSuchCountryException if a country with the primary key could not be found
	 */
	@Override
	public Country remove(Serializable primaryKey)
		throws NoSuchCountryException {

		Session session = null;

		try {
			session = openSession();

			Country country = (Country)session.get(
				CountryImpl.class, primaryKey);

			if (country == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCountryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(country);
		}
		catch (NoSuchCountryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Country removeImpl(Country country) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(country)) {
				country = (Country)session.get(
					CountryImpl.class, country.getPrimaryKeyObj());
			}

			if (country != null) {
				session.delete(country);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (country != null) {
			clearCache(country);
		}

		return country;
	}

	@Override
	public Country updateImpl(Country country) {
		boolean isNew = country.isNew();

		if (!(country instanceof CountryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(country.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(country);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in country proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Country implementation " +
					country.getClass());
		}

		CountryModelImpl countryModelImpl = (CountryModelImpl)country;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(country);
			}
			else {
				country = (Country)session.merge(country);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(CountryImpl.class, countryModelImpl, false, true);

		if (isNew) {
			country.setNew(false);
		}

		country.resetOriginalValues();

		return country;
	}

	/**
	 * Returns the country with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the country
	 * @return the country
	 * @throws NoSuchCountryException if a country with the primary key could not be found
	 */
	@Override
	public Country findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCountryException {

		Country country = fetchByPrimaryKey(primaryKey);

		if (country == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCountryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return country;
	}

	/**
	 * Returns the country with the primary key or throws a <code>NoSuchCountryException</code> if it could not be found.
	 *
	 * @param countryCode the primary key of the country
	 * @return the country
	 * @throws NoSuchCountryException if a country with the primary key could not be found
	 */
	@Override
	public Country findByPrimaryKey(String countryCode)
		throws NoSuchCountryException {

		return findByPrimaryKey((Serializable)countryCode);
	}

	/**
	 * Returns the country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param countryCode the primary key of the country
	 * @return the country, or <code>null</code> if a country with the primary key could not be found
	 */
	@Override
	public Country fetchByPrimaryKey(String countryCode) {
		return fetchByPrimaryKey((Serializable)countryCode);
	}

	/**
	 * Returns all the countries.
	 *
	 * @return the countries
	 */
	@Override
	public List<Country> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Country> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Country> findAll(
		int start, int end, OrderByComparator<Country> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Country> findAll(
		int start, int end, OrderByComparator<Country> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Country> list = null;

		if (useFinderCache) {
			list = (List<Country>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COUNTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COUNTRY;

				sql = sql.concat(CountryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Country>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the countries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Country country : findAll()) {
			remove(country);
		}
	}

	/**
	 * Returns the number of countries.
	 *
	 * @return the number of countries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COUNTRY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "countryCode";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COUNTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CountryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the country persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CountryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Country.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByContinentCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContinentCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"continentCode"}, true);

		_finderPathWithoutPaginationFindByContinentCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContinentCode",
			new String[] {String.class.getName()},
			new String[] {"continentCode"}, true);

		_finderPathCountByContinentCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContinentCode",
			new String[] {String.class.getName()},
			new String[] {"continentCode"}, false);

		_setCountryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCountryUtilPersistence(null);

		entityCache.removeCache(CountryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setCountryUtilPersistence(
		CountryPersistence countryPersistence) {

		try {
			Field field = CountryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, countryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COUNTRY =
		"SELECT country FROM Country country";

	private static final String _SQL_SELECT_COUNTRY_WHERE =
		"SELECT country FROM Country country WHERE ";

	private static final String _SQL_COUNT_COUNTRY =
		"SELECT COUNT(country) FROM Country country";

	private static final String _SQL_COUNT_COUNTRY_WHERE =
		"SELECT COUNT(country) FROM Country country WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "country.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Country exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Country exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CountryPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class CountryModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			CountryModelImpl countryModelImpl = (CountryModelImpl)baseModel;

			long columnBitmask = countryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(countryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						countryModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(countryModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			CountryModelImpl countryModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = countryModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = countryModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}