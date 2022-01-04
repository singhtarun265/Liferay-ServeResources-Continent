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

package com.liferay.serve.resource.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.serve.resource.model.States;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing States in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StatesCacheModel implements CacheModel<States>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StatesCacheModel)) {
			return false;
		}

		StatesCacheModel statesCacheModel = (StatesCacheModel)object;

		if (stateAbbrev.equals(statesCacheModel.stateAbbrev)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stateAbbrev);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{stateAbbrev=");
		sb.append(stateAbbrev);
		sb.append(", stateName=");
		sb.append(stateName);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public States toEntityModel() {
		StatesImpl statesImpl = new StatesImpl();

		if (stateAbbrev == null) {
			statesImpl.setStateAbbrev("");
		}
		else {
			statesImpl.setStateAbbrev(stateAbbrev);
		}

		if (stateName == null) {
			statesImpl.setStateName("");
		}
		else {
			statesImpl.setStateName(stateName);
		}

		if (countryCode == null) {
			statesImpl.setCountryCode("");
		}
		else {
			statesImpl.setCountryCode(countryCode);
		}

		statesImpl.resetOriginalValues();

		return statesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stateAbbrev = objectInput.readUTF();
		stateName = objectInput.readUTF();
		countryCode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (stateAbbrev == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stateAbbrev);
		}

		if (stateName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stateName);
		}

		if (countryCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(countryCode);
		}
	}

	public String stateAbbrev;
	public String stateName;
	public String countryCode;

}