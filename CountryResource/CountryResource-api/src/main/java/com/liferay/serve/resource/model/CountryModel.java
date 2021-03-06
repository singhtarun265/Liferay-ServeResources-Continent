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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Country service. Represents a row in the &quot;FOO_Country&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.serve.resource.model.impl.CountryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.serve.resource.model.impl.CountryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Country
 * @generated
 */
@ProviderType
public interface CountryModel extends BaseModel<Country> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a country model instance should use the {@link Country} interface instead.
	 */

	/**
	 * Returns the primary key of this country.
	 *
	 * @return the primary key of this country
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this country.
	 *
	 * @param primaryKey the primary key of this country
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the country code of this country.
	 *
	 * @return the country code of this country
	 */
	@AutoEscape
	public String getCountryCode();

	/**
	 * Sets the country code of this country.
	 *
	 * @param countryCode the country code of this country
	 */
	public void setCountryCode(String countryCode);

	/**
	 * Returns the continent code of this country.
	 *
	 * @return the continent code of this country
	 */
	@AutoEscape
	public String getContinentCode();

	/**
	 * Sets the continent code of this country.
	 *
	 * @param continentCode the continent code of this country
	 */
	public void setContinentCode(String continentCode);

	/**
	 * Returns the country name of this country.
	 *
	 * @return the country name of this country
	 */
	@AutoEscape
	public String getCountryName();

	/**
	 * Sets the country name of this country.
	 *
	 * @param countryName the country name of this country
	 */
	public void setCountryName(String countryName);

	/**
	 * Returns the full name of this country.
	 *
	 * @return the full name of this country
	 */
	@AutoEscape
	public String getFullName();

	/**
	 * Sets the full name of this country.
	 *
	 * @param fullName the full name of this country
	 */
	public void setFullName(String fullName);

}