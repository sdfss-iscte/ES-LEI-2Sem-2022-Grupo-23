package org.apache.ibatis.datasource.unpooled;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Executors;

public class UnpooledDataSourceProduct {
	private Boolean autoCommit;
	private Integer defaultTransactionIsolationLevel;
	private Integer defaultNetworkTimeout;

	public Boolean getAutoCommit() {
		return autoCommit;
	}

	public void setAutoCommit(Boolean autoCommit) {
		this.autoCommit = autoCommit;
	}

	public Integer getDefaultTransactionIsolationLevel() {
		return defaultTransactionIsolationLevel;
	}

	public void setDefaultTransactionIsolationLevel(Integer defaultTransactionIsolationLevel) {
		this.defaultTransactionIsolationLevel = defaultTransactionIsolationLevel;
	}

	public Integer getDefaultNetworkTimeout() {
		return defaultNetworkTimeout;
	}

	public void setDefaultNetworkTimeout(Integer defaultNetworkTimeout) {
		this.defaultNetworkTimeout = defaultNetworkTimeout;
	}

	public void configureConnection(Connection conn) throws SQLException {
		if (defaultNetworkTimeout != null) {
			conn.setNetworkTimeout(Executors.newSingleThreadExecutor(), defaultNetworkTimeout);
		}
		if (autoCommit != null && autoCommit != conn.getAutoCommit()) {
			conn.setAutoCommit(autoCommit);
		}
		if (defaultTransactionIsolationLevel != null) {
			conn.setTransactionIsolation(defaultTransactionIsolationLevel);
		}
	}
}