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
 * The base model interface for the Continent service. Represents a row in the &quot;FOO_Continent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.serve.resource.model.impl.ContinentModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.serve.resource.model.impl.ContinentImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Continent
 * @generated
 */
@ProviderType
public interface ContinentModel extends BaseModel<Continent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a continent model instance should use the {@link Continent} interface instead.
	 */

	/**
	 * Returns the primary key of this continent.
	 *
	 * @return the primary key of this continent
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this continent.
	 *
	 * @param primaryKey the primary key of this continent
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the continent code of this continent.
	 *
	 * @return the continent code of this continent
	 */
	@AutoEscape
	public String getContinentCode();

	/**
	 * Sets the continent code of this continent.
	 *
	 * @param continentCode the continent code of this continent
	 */
	public void setContinentCode(String continentCode);

	/**
	 * Returns the continent name of this continent.
	 *
	 * @return the continent name of this continent
	 */
	@AutoEscape
	public String getContinentName();

	/**
	 * Sets the continent name of this continent.
	 *
	 * @param continentName the continent name of this continent
	 */
	public void setContinentName(String continentName);

}