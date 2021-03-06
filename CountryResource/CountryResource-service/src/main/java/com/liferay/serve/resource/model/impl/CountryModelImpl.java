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

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.serve.resource.model.Country;
import com.liferay.serve.resource.model.CountryModel;
import com.liferay.serve.resource.model.CountrySoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Country service. Represents a row in the &quot;FOO_Country&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CountryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CountryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CountryImpl
 * @generated
 */
@JSON(strict = true)
public class CountryModelImpl
	extends BaseModelImpl<Country> implements CountryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a country model instance should use the <code>Country</code> interface instead.
	 */
	public static final String TABLE_NAME = "FOO_Country";

	public static final Object[][] TABLE_COLUMNS = {
		{"countryCode", Types.VARCHAR}, {"continentCode", Types.VARCHAR},
		{"countryName", Types.VARCHAR}, {"fullName", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("countryCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("continentCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("countryName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fullName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table FOO_Country (countryCode VARCHAR(75) not null primary key,continentCode VARCHAR(75) null,countryName VARCHAR(75) null,fullName VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table FOO_Country";

	public static final String ORDER_BY_JPQL =
		" ORDER BY country.countryCode ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY FOO_Country.countryCode ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CONTINENTCODE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COUNTRYCODE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static Country toModel(CountrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Country model = new CountryImpl();

		model.setCountryCode(soapModel.getCountryCode());
		model.setContinentCode(soapModel.getContinentCode());
		model.setCountryName(soapModel.getCountryName());
		model.setFullName(soapModel.getFullName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<Country> toModels(CountrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Country> models = new ArrayList<Country>(soapModels.length);

		for (CountrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CountryModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _countryCode;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCountryCode(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _countryCode;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Country.class;
	}

	@Override
	public String getModelClassName() {
		return Country.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Country, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Country, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Country, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Country)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Country, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Country, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Country)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Country, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Country, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Country>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Country.class.getClassLoader(), Country.class, ModelWrapper.class);

		try {
			Constructor<Country> constructor =
				(Constructor<Country>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Country, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Country, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Country, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Country, Object>>();
		Map<String, BiConsumer<Country, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Country, ?>>();

		attributeGetterFunctions.put("countryCode", Country::getCountryCode);
		attributeSetterBiConsumers.put(
			"countryCode",
			(BiConsumer<Country, String>)Country::setCountryCode);
		attributeGetterFunctions.put(
			"continentCode", Country::getContinentCode);
		attributeSetterBiConsumers.put(
			"continentCode",
			(BiConsumer<Country, String>)Country::setContinentCode);
		attributeGetterFunctions.put("countryName", Country::getCountryName);
		attributeSetterBiConsumers.put(
			"countryName",
			(BiConsumer<Country, String>)Country::setCountryName);
		attributeGetterFunctions.put("fullName", Country::getFullName);
		attributeSetterBiConsumers.put(
			"fullName", (BiConsumer<Country, String>)Country::setFullName);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getCountryCode() {
		if (_countryCode == null) {
			return "";
		}
		else {
			return _countryCode;
		}
	}

	@Override
	public void setCountryCode(String countryCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_countryCode = countryCode;
	}

	@JSON
	@Override
	public String getContinentCode() {
		if (_continentCode == null) {
			return "";
		}
		else {
			return _continentCode;
		}
	}

	@Override
	public void setContinentCode(String continentCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_continentCode = continentCode;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalContinentCode() {
		return getColumnOriginalValue("continentCode");
	}

	@JSON
	@Override
	public String getCountryName() {
		if (_countryName == null) {
			return "";
		}
		else {
			return _countryName;
		}
	}

	@Override
	public void setCountryName(String countryName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_countryName = countryName;
	}

	@JSON
	@Override
	public String getFullName() {
		if (_fullName == null) {
			return "";
		}
		else {
			return _fullName;
		}
	}

	@Override
	public void setFullName(String fullName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fullName = fullName;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public Country toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Country>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CountryImpl countryImpl = new CountryImpl();

		countryImpl.setCountryCode(getCountryCode());
		countryImpl.setContinentCode(getContinentCode());
		countryImpl.setCountryName(getCountryName());
		countryImpl.setFullName(getFullName());

		countryImpl.resetOriginalValues();

		return countryImpl;
	}

	@Override
	public int compareTo(Country country) {
		String primaryKey = country.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Country)) {
			return false;
		}

		Country country = (Country)object;

		String primaryKey = country.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Country> toCacheModel() {
		CountryCacheModel countryCacheModel = new CountryCacheModel();

		countryCacheModel.countryCode = getCountryCode();

		String countryCode = countryCacheModel.countryCode;

		if ((countryCode != null) && (countryCode.length() == 0)) {
			countryCacheModel.countryCode = null;
		}

		countryCacheModel.continentCode = getContinentCode();

		String continentCode = countryCacheModel.continentCode;

		if ((continentCode != null) && (continentCode.length() == 0)) {
			countryCacheModel.continentCode = null;
		}

		countryCacheModel.countryName = getCountryName();

		String countryName = countryCacheModel.countryName;

		if ((countryName != null) && (countryName.length() == 0)) {
			countryCacheModel.countryName = null;
		}

		countryCacheModel.fullName = getFullName();

		String fullName = countryCacheModel.fullName;

		if ((fullName != null) && (fullName.length() == 0)) {
			countryCacheModel.fullName = null;
		}

		return countryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Country, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Country, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Country, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Country)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Country, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Country, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Country, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Country)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Country>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _countryCode;
	private String _continentCode;
	private String _countryName;
	private String _fullName;

	public <T> T getColumnValue(String columnName) {
		Function<Country, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Country)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("countryCode", _countryCode);
		_columnOriginalValues.put("continentCode", _continentCode);
		_columnOriginalValues.put("countryName", _countryName);
		_columnOriginalValues.put("fullName", _fullName);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("countryCode", 1L);

		columnBitmasks.put("continentCode", 2L);

		columnBitmasks.put("countryName", 4L);

		columnBitmasks.put("fullName", 8L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Country _escapedModel;

}