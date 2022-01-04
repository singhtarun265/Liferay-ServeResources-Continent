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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.serve.resource.service.http.ContinentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ContinentSoap implements Serializable {

	public static ContinentSoap toSoapModel(Continent model) {
		ContinentSoap soapModel = new ContinentSoap();

		soapModel.setContinentCode(model.getContinentCode());
		soapModel.setContinentName(model.getContinentName());

		return soapModel;
	}

	public static ContinentSoap[] toSoapModels(Continent[] models) {
		ContinentSoap[] soapModels = new ContinentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContinentSoap[][] toSoapModels(Continent[][] models) {
		ContinentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContinentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContinentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContinentSoap[] toSoapModels(List<Continent> models) {
		List<ContinentSoap> soapModels = new ArrayList<ContinentSoap>(
			models.size());

		for (Continent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContinentSoap[soapModels.size()]);
	}

	public ContinentSoap() {
	}

	public String getPrimaryKey() {
		return _continentCode;
	}

	public void setPrimaryKey(String pk) {
		setContinentCode(pk);
	}

	public String getContinentCode() {
		return _continentCode;
	}

	public void setContinentCode(String continentCode) {
		_continentCode = continentCode;
	}

	public String getContinentName() {
		return _continentName;
	}

	public void setContinentName(String continentName) {
		_continentName = continentName;
	}

	private String _continentCode;
	private String _continentName;

}