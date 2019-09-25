package io.openslice.tmf.scm.model;


public enum ELifecycle {

	IN_STUDY("In study"),
	IN_DESIGN("In design"),
	IN_TEST("In test"),
	ACTIVE("Active"),
	LAUNCHED("Launched"),
	RETIRED("Retired"),
	OBSOLETE("Obsolete"),
	REJECTED("Rejected");
	
	
	private String value;
	
	ELifecycle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static ELifecycle getEnum(String value) {
        for(ELifecycle v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
