package com.sbt;

public enum ActiveFlag {

	ACTIVE("Active"),
	INACTIVE("Inactive");
	
	private String activeFlag;
	private ActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	public String getActiveFlag() {
		return activeFlag;
	}
	
	public static ActiveFlag getActiveFlag(String activeFlag) {
		ActiveFlag returnValue = null;
		if(activeFlag != null && !activeFlag.trim().equals("")) {
			ActiveFlag[] activeFlags = ActiveFlag.values();
			for(ActiveFlag af : activeFlags) {
				if(af.getActiveFlag().equals(activeFlag)) {
					returnValue = af;
					break;
				}
			}
		}
		return returnValue;
	}
	
}
