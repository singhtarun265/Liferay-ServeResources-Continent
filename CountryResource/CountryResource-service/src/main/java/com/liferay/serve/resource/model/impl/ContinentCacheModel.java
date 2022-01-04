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
import com.liferay.serve.resource.model.Continent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Continent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContinentCacheModel
	implements CacheModel<Continent>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ContinentCacheModel)) {
			return false;
		}

		ContinentCacheModel continentCacheModel = (ContinentCacheModel)object;

		if (continentCode.equals(continentCacheModel.continentCode)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, continentCode);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{continentCode=");
		sb.append(continentCode);
		sb.append(", continentName=");
		sb.append(continentName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Continent toEntityModel() {
		ContinentImpl continentImpl = new ContinentImpl();

		if (continentCode == null) {
			continentImpl.setContinentCode("");
		}
		else {
			continentImpl.setContinentCode(continentCode);
		}

		if (continentName == null) {
			continentImpl.setContinentName("");
		}
		else {
			continentImpl.setContinentName(continentName);
		}

		continentImpl.resetOriginalValues();

		return continentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		continentCode = objectInput.readUTF();
		continentName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (continentCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(continentCode);
		}

		if (continentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(continentName);
		}
	}

	public String continentCode;
	public String continentName;

}