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
 * The base model interface for the States service. Represents a row in the &quot;FOO_States&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.serve.resource.model.impl.StatesModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.serve.resource.model.impl.StatesImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see States
 * @generated
 */
@ProviderType
public interface StatesModel extends BaseModel<States> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a states model instance should use the {@link States} interface instead.
	 */

	/**
	 * Returns the primary key of this states.
	 *
	 * @return the primary key of this states
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this states.
	 *
	 * @param primaryKey the primary key of this states
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the state abbrev of this states.
	 *
	 * @return the state abbrev of this states
	 */
	@AutoEscape
	public String getStateAbbrev();

	/**
	 * Sets the state abbrev of this states.
	 *
	 * @param stateAbbrev the state abbrev of this states
	 */
	public void setStateAbbrev(String stateAbbrev);

	/**
	 * Returns the state name of this states.
	 *
	 * @return the state name of this states
	 */
	@AutoEscape
	public String getStateName();

	/**
	 * Sets the state name of this states.
	 *
	 * @param stateName the state name of this states
	 */
	public void setStateName(String stateName);

	/**
	 * Returns the country code of this states.
	 *
	 * @return the country code of this states
	 */
	@AutoEscape
	public String getCountryCode();

	/**
	 * Sets the country code of this states.
	 *
	 * @param countryCode the country code of this states
	 */
	public void setCountryCode(String countryCode);

}