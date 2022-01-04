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
import com.liferay.serve.resource.exception.NoSuchContinentException;
import com.liferay.serve.resource.model.Continent;
import com.liferay.serve.resource.model.impl.ContinentImpl;
import com.liferay.serve.resource.model.impl.ContinentModelImpl;
import com.liferay.serve.resource.service.persistence.ContinentPersistence;
import com.liferay.serve.resource.service.persistence.ContinentUtil;
import com.liferay.serve.resource.service.persistence.impl.constants.FOOPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the continent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ContinentPersistence.class)
public class ContinentPersistenceImpl
	extends BasePersistenceImpl<Continent> implements ContinentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ContinentUtil</code> to access the continent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ContinentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ContinentPersistenceImpl() {
		setModelClass(Continent.class);

		setModelImplClass(ContinentImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the continent in the entity cache if it is enabled.
	 *
	 * @param continent the continent
	 */
	@Override
	public void cacheResult(Continent continent) {
		entityCache.putResult(
			ContinentImpl.class, continent.getPrimaryKey(), continent);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the continents in the entity cache if it is enabled.
	 *
	 * @param continents the continents
	 */
	@Override
	public void cacheResult(List<Continent> continents) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (continents.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Continent continent : continents) {
			if (entityCache.getResult(
					ContinentImpl.class, continent.getPrimaryKey()) == null) {

				cacheResult(continent);
			}
		}
	}

	/**
	 * Clears the cache for all continents.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ContinentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the continent.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Continent continent) {
		entityCache.removeResult(ContinentImpl.class, continent);
	}

	@Override
	public void clearCache(List<Continent> continents) {
		for (Continent continent : continents) {
			entityCache.removeResult(ContinentImpl.class, continent);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ContinentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new continent with the primary key. Does not add the continent to the database.
	 *
	 * @param continentCode the primary key for the new continent
	 * @return the new continent
	 */
	@Override
	public Continent create(String continentCode) {
		Continent continent = new ContinentImpl();

		continent.setNew(true);
		continent.setPrimaryKey(continentCode);

		return continent;
	}

	/**
	 * Removes the continent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param continentCode the primary key of the continent
	 * @return the continent that was removed
	 * @throws NoSuchContinentException if a continent with the primary key could not be found
	 */
	@Override
	public Continent remove(String continentCode)
		throws NoSuchContinentException {

		return remove((Serializable)continentCode);
	}

	/**
	 * Removes the continent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the continent
	 * @return the continent that was removed
	 * @throws NoSuchContinentException if a continent with the primary key could not be found
	 */
	@Override
	public Continent remove(Serializable primaryKey)
		throws NoSuchContinentException {

		Session session = null;

		try {
			session = openSession();

			Continent continent = (Continent)session.get(
				ContinentImpl.class, primaryKey);

			if (continent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContinentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(continent);
		}
		catch (NoSuchContinentException noSuchEntityException) {
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
	protected Continent removeImpl(Continent continent) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(continent)) {
				continent = (Continent)session.get(
					ContinentImpl.class, continent.getPrimaryKeyObj());
			}

			if (continent != null) {
				session.delete(continent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (continent != null) {
			clearCache(continent);
		}

		return continent;
	}

	@Override
	public Continent updateImpl(Continent continent) {
		boolean isNew = continent.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(continent);
			}
			else {
				continent = (Continent)session.merge(continent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ContinentImpl.class, continent, false, true);

		if (isNew) {
			continent.setNew(false);
		}

		continent.resetOriginalValues();

		return continent;
	}

	/**
	 * Returns the continent with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the continent
	 * @return the continent
	 * @throws NoSuchContinentException if a continent with the primary key could not be found
	 */
	@Override
	public Continent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContinentException {

		Continent continent = fetchByPrimaryKey(primaryKey);

		if (continent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContinentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return continent;
	}

	/**
	 * Returns the continent with the primary key or throws a <code>NoSuchContinentException</code> if it could not be found.
	 *
	 * @param continentCode the primary key of the continent
	 * @return the continent
	 * @throws NoSuchContinentException if a continent with the primary key could not be found
	 */
	@Override
	public Continent findByPrimaryKey(String continentCode)
		throws NoSuchContinentException {

		return findByPrimaryKey((Serializable)continentCode);
	}

	/**
	 * Returns the continent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param continentCode the primary key of the continent
	 * @return the continent, or <code>null</code> if a continent with the primary key could not be found
	 */
	@Override
	public Continent fetchByPrimaryKey(String continentCode) {
		return fetchByPrimaryKey((Serializable)continentCode);
	}

	/**
	 * Returns all the continents.
	 *
	 * @return the continents
	 */
	@Override
	public List<Continent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Continent> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Continent> findAll(
		int start, int end, OrderByComparator<Continent> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Continent> findAll(
		int start, int end, OrderByComparator<Continent> orderByComparator,
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

		List<Continent> list = null;

		if (useFinderCache) {
			list = (List<Continent>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CONTINENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CONTINENT;

				sql = sql.concat(ContinentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Continent>)QueryUtil.list(
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
	 * Removes all the continents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Continent continent : findAll()) {
			remove(continent);
		}
	}

	/**
	 * Returns the number of continents.
	 *
	 * @return the number of continents
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CONTINENT);

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
		return "continentCode";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONTINENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ContinentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the continent persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ContinentModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Continent.class.getName()));

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

		_setContinentUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setContinentUtilPersistence(null);

		entityCache.removeCache(ContinentImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setContinentUtilPersistence(
		ContinentPersistence continentPersistence) {

		try {
			Field field = ContinentUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, continentPersistence);
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

	private static final String _SQL_SELECT_CONTINENT =
		"SELECT continent FROM Continent continent";

	private static final String _SQL_COUNT_CONTINENT =
		"SELECT COUNT(continent) FROM Continent continent";

	private static final String _ORDER_BY_ENTITY_ALIAS = "continent.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Continent exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ContinentPersistenceImpl.class);

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

	private static class ContinentModelArgumentsResolver
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

			ContinentModelImpl continentModelImpl =
				(ContinentModelImpl)baseModel;

			long columnBitmask = continentModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(continentModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						continentModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(continentModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ContinentModelImpl continentModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = continentModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = continentModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}