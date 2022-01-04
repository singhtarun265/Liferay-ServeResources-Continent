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
 * This class is a wrapper for {@link Continent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Continent
 * @generated
 */
public class ContinentWrapper
	extends BaseModelWrapper<Continent>
	implements Continent, ModelWrapper<Continent> {

	public ContinentWrapper(Continent continent) {
		super(continent);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("continentCode", getContinentCode());
		attributes.put("continentName", getContinentName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String continentCode = (String)attributes.get("continentCode");

		if (continentCode != null) {
			setContinentCode(continentCode);
		}

		String continentName = (String)attributes.get("continentName");

		if (continentName != null) {
			setContinentName(continentName);
		}
	}

	/**
	 * Returns the continent code of this continent.
	 *
	 * @return the continent code of this continent
	 */
	@Override
	public String getContinentCode() {
		return model.getContinentCode();
	}

	/**
	 * Returns the continent name of this continent.
	 *
	 * @return the continent name of this continent
	 */
	@Override
	public String getContinentName() {
		return model.getContinentName();
	}

	/**
	 * Returns the primary key of this continent.
	 *
	 * @return the primary key of this continent
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the continent code of this continent.
	 *
	 * @param continentCode the continent code of this continent
	 */
	@Override
	public void setContinentCode(String continentCode) {
		model.setContinentCode(continentCode);
	}

	/**
	 * Sets the continent name of this continent.
	 *
	 * @param continentName the continent name of this continent
	 */
	@Override
	public void setContinentName(String continentName) {
		model.setContinentName(continentName);
	}

	/**
	 * Sets the primary key of this continent.
	 *
	 * @param primaryKey the primary key of this continent
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected ContinentWrapper wrap(Continent continent) {
		return new ContinentWrapper(continent);
	}

}