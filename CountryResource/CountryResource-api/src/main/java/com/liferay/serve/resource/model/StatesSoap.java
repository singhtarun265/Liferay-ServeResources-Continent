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
 * This class is used by SOAP remote services, specifically {@link com.liferay.serve.resource.service.http.StatesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class StatesSoap implements Serializable {

	public static StatesSoap toSoapModel(States model) {
		StatesSoap soapModel = new StatesSoap();

		soapModel.setStateAbbrev(model.getStateAbbrev());
		soapModel.setStateName(model.getStateName());
		soapModel.setCountryCode(model.getCountryCode());

		return soapModel;
	}

	public static StatesSoap[] toSoapModels(States[] models) {
		StatesSoap[] soapModels = new StatesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatesSoap[][] toSoapModels(States[][] models) {
		StatesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatesSoap[] toSoapModels(List<States> models) {
		List<StatesSoap> soapModels = new ArrayList<StatesSoap>(models.size());

		for (States model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatesSoap[soapModels.size()]);
	}

	public StatesSoap() {
	}

	public String getPrimaryKey() {
		return _stateAbbrev;
	}

	public void setPrimaryKey(String pk) {
		setStateAbbrev(pk);
	}

	public String getStateAbbrev() {
		return _stateAbbrev;
	}

	public void setStateAbbrev(String stateAbbrev) {
		_stateAbbrev = stateAbbrev;
	}

	public String getStateName() {
		return _stateName;
	}

	public void setStateName(String stateName) {
		_stateName = stateName;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	private String _stateAbbrev;
	private String _stateName;
	private String _countryCode;

}