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
import com.liferay.serve.resource.exception.NoSuchStatesException;
import com.liferay.serve.resource.model.States;
import com.liferay.serve.resource.model.impl.StatesImpl;
import com.liferay.serve.resource.model.impl.StatesModelImpl;
import com.liferay.serve.resource.service.persistence.StatesPersistence;
import com.liferay.serve.resource.service.persistence.StatesUtil;
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
 * The persistence implementation for the states service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StatesPersistence.class)
public class StatesPersistenceImpl
	extends BasePersistenceImpl<States> implements StatesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StatesUtil</code> to access the states persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StatesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCountryCode;
	private FinderPath _finderPathWithoutPaginationFindByCountryCode;
	private FinderPath _finderPathCountByCountryCode;

	/**
	 * Returns all the stateses where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @return the matching stateses
	 */
	@Override
	public List<States> findByCountryCode(String countryCode) {
		return findByCountryCode(
			countryCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<States> findByCountryCode(
		String countryCode, int start, int end) {

		return findByCountryCode(countryCode, start, end, null);
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
	@Override
	public List<States> findByCountryCode(
		String countryCode, int start, int end,
		OrderByComparator<States> orderByComparator) {

		return findByCountryCode(
			countryCode, start, end, orderByComparator, true);
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
	@Override
	public List<States> findByCountryCode(
		String countryCode, int start, int end,
		OrderByComparator<States> orderByComparator, boolean useFinderCache) {

		countryCode = Objects.toString(countryCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCountryCode;
				finderArgs = new Object[] {countryCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCountryCode;
			finderArgs = new Object[] {
				countryCode, start, end, orderByComparator
			};
		}

		List<States> list = null;

		if (useFinderCache) {
			list = (List<States>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (States states : list) {
					if (!countryCode.equals(states.getCountryCode())) {
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

			sb.append(_SQL_SELECT_STATES_WHERE);

			boolean bindCountryCode = false;

			if (countryCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_COUNTRYCODE_COUNTRYCODE_3);
			}
			else {
				bindCountryCode = true;

				sb.append(_FINDER_COLUMN_COUNTRYCODE_COUNTRYCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StatesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCountryCode) {
					queryPos.add(countryCode);
				}

				list = (List<States>)QueryUtil.list(
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
	 * Returns the first states in the ordered set where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching states
	 * @throws NoSuchStatesException if a matching states could not be found
	 */
	@Override
	public States findByCountryCode_First(
			String countryCode, OrderByComparator<States> orderByComparator)
		throws NoSuchStatesException {

		States states = fetchByCountryCode_First(
			countryCode, orderByComparator);

		if (states != null) {
			return states;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("countryCode=");
		sb.append(countryCode);

		sb.append("}");

		throw new NoSuchStatesException(sb.toString());
	}

	/**
	 * Returns the first states in the ordered set where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching states, or <code>null</code> if a matching states could not be found
	 */
	@Override
	public States fetchByCountryCode_First(
		String countryCode, OrderByComparator<States> orderByComparator) {

		List<States> list = findByCountryCode(
			countryCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last states in the ordered set where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching states
	 * @throws NoSuchStatesException if a matching states could not be found
	 */
	@Override
	public States findByCountryCode_Last(
			String countryCode, OrderByComparator<States> orderByComparator)
		throws NoSuchStatesException {

		States states = fetchByCountryCode_Last(countryCode, orderByComparator);

		if (states != null) {
			return states;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("countryCode=");
		sb.append(countryCode);

		sb.append("}");

		throw new NoSuchStatesException(sb.toString());
	}

	/**
	 * Returns the last states in the ordered set where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching states, or <code>null</code> if a matching states could not be found
	 */
	@Override
	public States fetchByCountryCode_Last(
		String countryCode, OrderByComparator<States> orderByComparator) {

		int count = countByCountryCode(countryCode);

		if (count == 0) {
			return null;
		}

		List<States> list = findByCountryCode(
			countryCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public States[] findByCountryCode_PrevAndNext(
			String stateAbbrev, String countryCode,
			OrderByComparator<States> orderByComparator)
		throws NoSuchStatesException {

		countryCode = Objects.toString(countryCode, "");

		States states = findByPrimaryKey(stateAbbrev);

		Session session = null;

		try {
			session = openSession();

			States[] array = new StatesImpl[3];

			array[0] = getByCountryCode_PrevAndNext(
				session, states, countryCode, orderByComparator, true);

			array[1] = states;

			array[2] = getByCountryCode_PrevAndNext(
				session, states, countryCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected States getByCountryCode_PrevAndNext(
		Session session, States states, String countryCode,
		OrderByComparator<States> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STATES_WHERE);

		boolean bindCountryCode = false;

		if (countryCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_COUNTRYCODE_COUNTRYCODE_3);
		}
		else {
			bindCountryCode = true;

			sb.append(_FINDER_COLUMN_COUNTRYCODE_COUNTRYCODE_2);
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
			sb.append(StatesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCountryCode) {
			queryPos.add(countryCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(states)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<States> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stateses where countryCode = &#63; from the database.
	 *
	 * @param countryCode the country code
	 */
	@Override
	public void removeByCountryCode(String countryCode) {
		for (States states :
				findByCountryCode(
					countryCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(states);
		}
	}

	/**
	 * Returns the number of stateses where countryCode = &#63;.
	 *
	 * @param countryCode the country code
	 * @return the number of matching stateses
	 */
	@Override
	public int countByCountryCode(String countryCode) {
		countryCode = Objects.toString(countryCode, "");

		FinderPath finderPath = _finderPathCountByCountryCode;

		Object[] finderArgs = new Object[] {countryCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STATES_WHERE);

			boolean bindCountryCode = false;

			if (countryCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_COUNTRYCODE_COUNTRYCODE_3);
			}
			else {
				bindCountryCode = true;

				sb.append(_FINDER_COLUMN_COUNTRYCODE_COUNTRYCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCountryCode) {
					queryPos.add(countryCode);
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

	private static final String _FINDER_COLUMN_COUNTRYCODE_COUNTRYCODE_2 =
		"states.countryCode = ?";

	private static final String _FINDER_COLUMN_COUNTRYCODE_COUNTRYCODE_3 =
		"(states.countryCode IS NULL OR states.countryCode = '')";

	public StatesPersistenceImpl() {
		setModelClass(States.class);

		setModelImplClass(StatesImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the states in the entity cache if it is enabled.
	 *
	 * @param states the states
	 */
	@Override
	public void cacheResult(States states) {
		entityCache.putResult(StatesImpl.class, states.getPrimaryKey(), states);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the stateses in the entity cache if it is enabled.
	 *
	 * @param stateses the stateses
	 */
	@Override
	public void cacheResult(List<States> stateses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (stateses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (States states : stateses) {
			if (entityCache.getResult(
					StatesImpl.class, states.getPrimaryKey()) == null) {

				cacheResult(states);
			}
		}
	}

	/**
	 * Clears the cache for all stateses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StatesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the states.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(States states) {
		entityCache.removeResult(StatesImpl.class, states);
	}

	@Override
	public void clearCache(List<States> stateses) {
		for (States states : stateses) {
			entityCache.removeResult(StatesImpl.class, states);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StatesImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new states with the primary key. Does not add the states to the database.
	 *
	 * @param stateAbbrev the primary key for the new states
	 * @return the new states
	 */
	@Override
	public States create(String stateAbbrev) {
		States states = new StatesImpl();

		states.setNew(true);
		states.setPrimaryKey(stateAbbrev);

		return states;
	}

	/**
	 * Removes the states with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateAbbrev the primary key of the states
	 * @return the states that was removed
	 * @throws NoSuchStatesException if a states with the primary key could not be found
	 */
	@Override
	public States remove(String stateAbbrev) throws NoSuchStatesException {
		return remove((Serializable)stateAbbrev);
	}

	/**
	 * Removes the states with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the states
	 * @return the states that was removed
	 * @throws NoSuchStatesException if a states with the primary key could not be found
	 */
	@Override
	public States remove(Serializable primaryKey) throws NoSuchStatesException {
		Session session = null;

		try {
			session = openSession();

			States states = (States)session.get(StatesImpl.class, primaryKey);

			if (states == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(states);
		}
		catch (NoSuchStatesException noSuchEntityException) {
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
	protected States removeImpl(States states) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(states)) {
				states = (States)session.get(
					StatesImpl.class, states.getPrimaryKeyObj());
			}

			if (states != null) {
				session.delete(states);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (states != null) {
			clearCache(states);
		}

		return states;
	}

	@Override
	public States updateImpl(States states) {
		boolean isNew = states.isNew();

		if (!(states instanceof StatesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(states.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(states);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in states proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom States implementation " +
					states.getClass());
		}

		StatesModelImpl statesModelImpl = (StatesModelImpl)states;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(states);
			}
			else {
				states = (States)session.merge(states);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(StatesImpl.class, statesModelImpl, false, true);

		if (isNew) {
			states.setNew(false);
		}

		states.resetOriginalValues();

		return states;
	}

	/**
	 * Returns the states with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the states
	 * @return the states
	 * @throws NoSuchStatesException if a states with the primary key could not be found
	 */
	@Override
	public States findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStatesException {

		States states = fetchByPrimaryKey(primaryKey);

		if (states == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStatesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return states;
	}

	/**
	 * Returns the states with the primary key or throws a <code>NoSuchStatesException</code> if it could not be found.
	 *
	 * @param stateAbbrev the primary key of the states
	 * @return the states
	 * @throws NoSuchStatesException if a states with the primary key could not be found
	 */
	@Override
	public States findByPrimaryKey(String stateAbbrev)
		throws NoSuchStatesException {

		return findByPrimaryKey((Serializable)stateAbbrev);
	}

	/**
	 * Returns the states with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateAbbrev the primary key of the states
	 * @return the states, or <code>null</code> if a states with the primary key could not be found
	 */
	@Override
	public States fetchByPrimaryKey(String stateAbbrev) {
		return fetchByPrimaryKey((Serializable)stateAbbrev);
	}

	/**
	 * Returns all the stateses.
	 *
	 * @return the stateses
	 */
	@Override
	public List<States> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<States> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<States> findAll(
		int start, int end, OrderByComparator<States> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<States> findAll(
		int start, int end, OrderByComparator<States> orderByComparator,
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

		List<States> list = null;

		if (useFinderCache) {
			list = (List<States>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STATES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STATES;

				sql = sql.concat(StatesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<States>)QueryUtil.list(
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
	 * Removes all the stateses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (States states : findAll()) {
			remove(states);
		}
	}

	/**
	 * Returns the number of stateses.
	 *
	 * @return the number of stateses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STATES);

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
		return "stateAbbrev";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STATES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StatesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the states persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new StatesModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", States.class.getName()));

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

		_finderPathWithPaginationFindByCountryCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCountryCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"countryCode"}, true);

		_finderPathWithoutPaginationFindByCountryCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCountryCode",
			new String[] {String.class.getName()}, new String[] {"countryCode"},
			true);

		_finderPathCountByCountryCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCountryCode",
			new String[] {String.class.getName()}, new String[] {"countryCode"},
			false);

		_setStatesUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setStatesUtilPersistence(null);

		entityCache.removeCache(StatesImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setStatesUtilPersistence(
		StatesPersistence statesPersistence) {

		try {
			Field field = StatesUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, statesPersistence);
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

	private static final String _SQL_SELECT_STATES =
		"SELECT states FROM States states";

	private static final String _SQL_SELECT_STATES_WHERE =
		"SELECT states FROM States states WHERE ";

	private static final String _SQL_COUNT_STATES =
		"SELECT COUNT(states) FROM States states";

	private static final String _SQL_COUNT_STATES_WHERE =
		"SELECT COUNT(states) FROM States states WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "states.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No States exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No States exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StatesPersistenceImpl.class);

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

	private static class StatesModelArgumentsResolver
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

			StatesModelImpl statesModelImpl = (StatesModelImpl)baseModel;

			long columnBitmask = statesModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(statesModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= statesModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(statesModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			StatesModelImpl statesModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = statesModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = statesModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}