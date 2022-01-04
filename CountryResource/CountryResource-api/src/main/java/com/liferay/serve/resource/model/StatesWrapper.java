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

package com.liferay.serve.resource.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link States}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see States
 * @generated
 */
public class StatesWrapper
	extends BaseModelWrapper<States> implements ModelWrapper<States>, States {

	public StatesWrapper(States states) {
		super(states);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stateAbbrev", getStateAbbrev());
		attributes.put("stateName", getStateName());
		attributes.put("countryCode", getCountryCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String stateAbbrev = (String)attributes.get("stateAbbrev");

		if (stateAbbrev != null) {
			setStateAbbrev(stateAbbrev);
		}

		String stateName = (String)attributes.get("stateName");

		if (stateName != null) {
			setStateName(stateName);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}
	}

	/**
	 * Returns the country code of this states.
	 *
	 * @return the country code of this states
	 */
	@Override
	public String getCountryCode() {
		return model.getCountryCode();
	}

	/**
	 * Returns the primary key of this states.
	 *
	 * @return the primary key of this states
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state abbrev of this states.
	 *
	 * @return the state abbrev of this states
	 */
	@Override
	public String getStateAbbrev() {
		return model.getStateAbbrev();
	}

	/**
	 * Returns the state name of this states.
	 *
	 * @return the state name of this states
	 */
	@Override
	public String getStateName() {
		return model.getStateName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the country code of this states.
	 *
	 * @param countryCode the country code of this states
	 */
	@Override
	public void setCountryCode(String countryCode) {
		model.setCountryCode(countryCode);
	}

	/**
	 * Sets the primary key of this states.
	 *
	 * @param primaryKey the primary key of this states
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state abbrev of this states.
	 *
	 * @param stateAbbrev the state abbrev of this states
	 */
	@Override
	public void setStateAbbrev(String stateAbbrev) {
		model.setStateAbbrev(stateAbbrev);
	}

	/**
	 * Sets the state name of this states.
	 *
	 * @param stateName the state name of this states
	 */
	@Override
	public void setStateName(String stateName) {
		model.setStateName(stateName);
	}

	@Override
	protected StatesWrapper wrap(States states) {
		return new StatesWrapper(states);
	}

}