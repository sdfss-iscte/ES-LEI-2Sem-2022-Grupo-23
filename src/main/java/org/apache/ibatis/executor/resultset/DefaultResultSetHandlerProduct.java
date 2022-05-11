package org.apache.ibatis.executor.resultset;


import java.util.Map;
import org.apache.ibatis.cache.CacheKey;
import java.util.HashMap;

public class DefaultResultSetHandlerProduct {
	private final Map<CacheKey, Object> nestedResultObjects = new HashMap<>();
	private final Map<String, Object> ancestorObjects = new HashMap<>();

	public Map<CacheKey, Object> getNestedResultObjects() {
		return nestedResultObjects;
	}

	public Map<String, Object> getAncestorObjects() {
		return ancestorObjects;
	}

	public void cleanUpAfterHandlingResultSet() {
		nestedResultObjects.clear();
	}

	public void putAncestor(Object resultObject, String resultMapId) {
		ancestorObjects.put(resultMapId, resultObject);
	}
}