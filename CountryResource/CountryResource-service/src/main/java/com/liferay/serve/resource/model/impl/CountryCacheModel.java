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
import com.liferay.serve.resource.model.Country;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Country in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CountryCacheModel implements CacheModel<Country>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CountryCacheModel)) {
			return false;
		}

		CountryCacheModel countryCacheModel = (CountryCacheModel)object;

		if (countryCode.equals(countryCacheModel.countryCode)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, countryCode);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{countryCode=");
		sb.append(countryCode);
		sb.append(", continentCode=");
		sb.append(continentCode);
		sb.append(", countryName=");
		sb.append(countryName);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Country toEntityModel() {
		CountryImpl countryImpl = new CountryImpl();

		if (countryCode == null) {
			countryImpl.setCountryCode("");
		}
		else {
			countryImpl.setCountryCode(countryCode);
		}

		if (continentCode == null) {
			countryImpl.setContinentCode("");
		}
		else {
			countryImpl.setContinentCode(continentCode);
		}

		if (countryName == null) {
			countryImpl.setCountryName("");
		}
		else {
			countryImpl.setCountryName(countryName);
		}

		if (fullName == null) {
			countryImpl.setFullName("");
		}
		else {
			countryImpl.setFullName(fullName);
		}

		countryImpl.resetOriginalValues();

		return countryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		countryCode = objectInput.readUTF();
		continentCode = objectInput.readUTF();
		countryName = objectInput.readUTF();
		fullName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (countryCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (continentCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(continentCode);
		}

		if (countryName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(countryName);
		}

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}
	}

	public String countryCode;
	public String continentCode;
	public String countryName;
	public String fullName;

}