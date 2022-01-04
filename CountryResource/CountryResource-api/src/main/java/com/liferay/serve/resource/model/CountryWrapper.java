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
 * This class is a wrapper for {@link Country}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Country
 * @generated
 */
public class CountryWrapper
	extends BaseModelWrapper<Country>
	implements Country, ModelWrapper<Country> {

	public CountryWrapper(Country country) {
		super(country);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("countryCode", getCountryCode());
		attributes.put("continentCode", getContinentCode());
		attributes.put("countryName", getCountryName());
		attributes.put("fullName", getFullName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String continentCode = (String)attributes.get("continentCode");

		if (continentCode != null) {
			setContinentCode(continentCode);
		}

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}
	}

	/**
	 * Returns the continent code of this country.
	 *
	 * @return the continent code of this country
	 */
	@Override
	public String getContinentCode() {
		return model.getContinentCode();
	}

	/**
	 * Returns the country code of this country.
	 *
	 * @return the country code of this country
	 */
	@Override
	public String getCountryCode() {
		return model.getCountryCode();
	}

	/**
	 * Returns the country name of this country.
	 *
	 * @return the country name of this country
	 */
	@Override
	public String getCountryName() {
		return model.getCountryName();
	}

	/**
	 * Returns the full name of this country.
	 *
	 * @return the full name of this country
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the primary key of this country.
	 *
	 * @return the primary key of this country
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
	 * Sets the continent code of this country.
	 *
	 * @param continentCode the continent code of this country
	 */
	@Override
	public void setContinentCode(String continentCode) {
		model.setContinentCode(continentCode);
	}

	/**
	 * Sets the country code of this country.
	 *
	 * @param countryCode the country code of this country
	 */
	@Override
	public void setCountryCode(String countryCode) {
		model.setCountryCode(countryCode);
	}

	/**
	 * Sets the country name of this country.
	 *
	 * @param countryName the country name of this country
	 */
	@Override
	public void setCountryName(String countryName) {
		model.setCountryName(countryName);
	}

	/**
	 * Sets the full name of this country.
	 *
	 * @param fullName the full name of this country
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the primary key of this country.
	 *
	 * @param primaryKey the primary key of this country
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected CountryWrapper wrap(Country country) {
		return new CountryWrapper(country);
	}

}