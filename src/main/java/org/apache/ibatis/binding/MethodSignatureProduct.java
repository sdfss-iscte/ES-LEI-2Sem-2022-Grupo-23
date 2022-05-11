package org.apache.ibatis.binding;


import org.apache.ibatis.session.RowBounds;

public class MethodSignatureProduct {
	private final Integer rowBoundsIndex;

	public MethodSignatureProduct(Integer getUniqueParamIndex) {
		this.rowBoundsIndex = getUniqueParamIndex;
	}

	public RowBounds extractRowBounds(Object[] args) {
		return hasRowBounds() ? (RowBounds) args[rowBoundsIndex] : null;
	}

	public boolean hasRowBounds() {
		return rowBoundsIndex != null;
	}
}