package org.apache.ibatis.builder;


public class MapperBuilderAssistantProduct {
    private String currentNamespace;

    public String getCurrentNamespace() {
	return currentNamespace;
    }

    public void setCurrentNamespace(String currentNamespace) {
	if (currentNamespace == null) {
	    throw new BuilderException("The mapper element requires a namespace attribute to be specified.");
	}
	if (this.currentNamespace != null && !this.currentNamespace.equals(currentNamespace)) {
	    throw new BuilderException(
		    "Wrong namespace. Expected '" + this.currentNamespace + "' but found '" + currentNamespace + "'.");
	}
	this.currentNamespace = currentNamespace;
    }

    public String applyCurrentNamespace(String base, boolean isReference) {
	if (base == null) {
	    return null;
	}
	if (isReference) {
	    if (base.contains(".")) {
		return base;
	    }
	} else {
	    if (base.startsWith(currentNamespace + ".")) {
		return base;
	    }
	    if (base.contains(".")) {
		throw new BuilderException("Dots are not allowed in element names, please remove it from " + base);
	    }
	}
	return currentNamespace + "." + base;
    }
}