package io.openslice.tmf.sim638.model;

public enum EServiceStartMode {
	UNKNOWN("UNKNOWN"),
	AUTOMATICALLY_MANAGED("AUTOMATICALLY_MANAGED"),
	AUTOMATICALLY_BY_DEVICE("AUTOMATICALLY_BY_DEVICE"),
	MANUALLY_BY_SERVICE_PROVIDER("MANUALLY_BY_SERVICE_PROVIDER"),
	MANUALLY_BY_CUSTOMER("MANUALLY_BY_CUSTOMER"),
	ANY("ANY");
	
	
	private String value;
	
	EServiceStartMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static EServiceStartMode getEnum(String value) {
        for(EServiceStartMode v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
