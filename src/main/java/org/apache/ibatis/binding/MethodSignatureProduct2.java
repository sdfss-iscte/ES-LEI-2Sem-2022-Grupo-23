package org.apache.ibatis.binding;


import org.apache.ibatis.session.ResultHandler;

public class MethodSignatureProduct2 {
	private final Integer resultHandlerIndex;

	public MethodSignatureProduct2(Integer getUniqueParamIndex) {
		this.resultHandlerIndex = getUniqueParamIndex;
	}

	public ResultHandler extractResultHandler(Object[] args) {
		return hasResultHandler() ? (ResultHandler) args[resultHandlerIndex] : null;
	}

	public boolean hasResultHandler() {
		return resultHandlerIndex != null;
	}
}