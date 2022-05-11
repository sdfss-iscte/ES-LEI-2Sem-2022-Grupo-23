package org.apache.ibatis.executor.loader;


import org.apache.ibatis.reflection.MetaObject;
import java.sql.SQLException;
import java.io.Serializable;
import org.apache.ibatis.executor.loader.ResultLoaderMap.LoadPair;

public class LoadPairProduct implements Serializable {
	private transient MetaObject metaResultObject;
	private transient ResultLoader resultLoader;

	public MetaObject getMetaResultObject() {
		return metaResultObject;
	}

	public void setMetaResultObject(MetaObject metaResultObject) {
		this.metaResultObject = metaResultObject;
	}

	public ResultLoader getResultLoader() {
		return resultLoader;
	}

	public void setResultLoader(ResultLoader resultLoader) {
		this.resultLoader = resultLoader;
	}

	public void load(LoadPair loadPair) throws SQLException {
		if (this.metaResultObject == null) {
			throw new IllegalArgumentException("metaResultObject is null");
		}
		if (this.resultLoader == null) {
			throw new IllegalArgumentException("resultLoader is null");
		}
		loadPair.load(null);
	}
}