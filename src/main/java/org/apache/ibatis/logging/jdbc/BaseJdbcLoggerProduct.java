package org.apache.ibatis.logging.jdbc;


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.sql.Array;
import org.apache.ibatis.reflection.ArrayUtil;
import java.sql.SQLException;

public class BaseJdbcLoggerProduct {
	private BaseJdbcLoggerProductProduct baseJdbcLoggerProductProduct = new BaseJdbcLoggerProductProduct();
	private final List<Object> columnValues = new ArrayList<>();

	public Object getColumn(Object key) {
		return baseJdbcLoggerProductProduct.getColumn(key);
	}

	public String getColumnString() {
		return baseJdbcLoggerProductProduct.getColumnString();
	}

	public String getParameterValueString() {
		List<Object> typeList = new ArrayList<>(columnValues.size());
		for (Object value : columnValues) {
			if (value == null) {
				typeList.add("null");
			} else {
				typeList.add(objectValueString(value) + "(" + value.getClass().getSimpleName() + ")");
			}
		}
		final String parameters = typeList.toString();
		return parameters.substring(1, parameters.length() - 1);
	}

	public void setColumn(Object key, Object value) {
		baseJdbcLoggerProductProduct.getColumnMap().put(key, value);
		baseJdbcLoggerProductProduct.getColumnNames().add(key);
		columnValues.add(value);
	}

	public void clearColumnInfo() {
		baseJdbcLoggerProductProduct.getColumnMap().clear();
		baseJdbcLoggerProductProduct.getColumnNames().clear();
		columnValues.clear();
	}

	public String objectValueString(Object value) {
		if (value instanceof Array) {
			try {
				return ArrayUtil.toString(((Array) value).getArray());
			} catch (SQLException e) {
				return value.toString();
			}
		}
		return value.toString();
	}
}