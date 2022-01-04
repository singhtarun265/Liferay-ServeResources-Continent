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

package com.liferay.serve.resource.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StatesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StatesLocalService
 * @generated
 */
public class StatesLocalServiceWrapper
	implements ServiceWrapper<StatesLocalService>, StatesLocalService {

	public StatesLocalServiceWrapper(StatesLocalService statesLocalService) {
		_statesLocalService = statesLocalService;
	}

	/**
	 * Adds the states to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param states the states
	 * @return the states that was added
	 */
	@Override
	public com.liferay.serve.resource.model.States addStates(
		com.liferay.serve.resource.model.States states) {

		return _statesLocalService.addStates(states);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new states with the primary key. Does not add the states to the database.
	 *
	 * @param stateAbbrev the primary key for the new states
	 * @return the new states
	 */
	@Override
	public com.liferay.serve.resource.model.States createStates(
		String stateAbbrev) {

		return _statesLocalService.createStates(stateAbbrev);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statesLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the states from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param states the states
	 * @return the states that was removed
	 */
	@Override
	public com.liferay.serve.resource.model.States deleteStates(
		com.liferay.serve.resource.model.States states) {

		return _statesLocalService.deleteStates(states);
	}

	/**
	 * Deletes the states with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stateAbbrev the primary key of the states
	 * @return the states that was removed
	 * @throws PortalException if a states with the primary key could not be found
	 */
	@Override
	public com.liferay.serve.resource.model.States deleteStates(
			String stateAbbrev)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statesLocalService.deleteStates(stateAbbrev);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _statesLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _statesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.serve.resource.model.impl.StatesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _statesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.serve.resource.model.impl.StatesModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _statesLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _statesLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _statesLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.serve.resource.model.States fetchStates(
		String stateAbbrev) {

		return _statesLocalService.fetchStates(stateAbbrev);
	}

	@Override
	public java.util.List<com.liferay.serve.resource.model.States>
			getByCountryCode(String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _statesLocalService.getByCountryCode(countryCode);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _statesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the states with the primary key.
	 *
	 * @param stateAbbrev the primary key of the states
	 * @return the states
	 * @throws PortalException if a states with the primary key could not be found
	 */
	@Override
	public com.liferay.serve.resource.model.States getStates(String stateAbbrev)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _statesLocalService.getStates(stateAbbrev);
	}

	/**
	 * Returns a range of all the stateses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.serve.resource.model.impl.StatesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stateses
	 * @param end the upper bound of the range of stateses (not inclusive)
	 * @return the range of stateses
	 */
	@Override
	public java.util.List<com.liferay.serve.resource.model.States> getStateses(
		int start, int end) {

		return _statesLocalService.getStateses(start, end);
	}

	/**
	 * Returns the number of stateses.
	 *
	 * @return the number of stateses
	 */
	@Override
	public int getStatesesCount() {
		return _statesLocalService.getStatesesCount();
	}

	/**
	 * Updates the states in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StatesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param states the states
	 * @return the states that was updated
	 */
	@Override
	public com.liferay.serve.resource.model.States updateStates(
		com.liferay.serve.resource.model.States states) {

		return _statesLocalService.updateStates(states);
	}

	@Override
	public StatesLocalService getWrappedService() {
		return _statesLocalService;
	}

	@Override
	public void setWrappedService(StatesLocalService statesLocalService) {
		_statesLocalService = statesLocalService;
	}

	private StatesLocalService _statesLocalService;

}