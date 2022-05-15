package org.apache.ibatis.logging.jdbc;


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class BaseJdbcLoggerProductProduct {
	private final Map<Object, Object> columnMap = new HashMap<>();
	private final List<Object> columnNames = new ArrayList<>();

	public Map<Object, Object> getColumnMap() {
		return columnMap;
	}

	public List<Object> getColumnNames() {
		return columnNames;
	}

	public Object getColumn(Object key) {
		return columnMap.get(key);
	}

	public String getColumnString() {
		return columnNames.toString();
	}
}