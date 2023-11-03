package io.openslice.tmf.lcm.model;


public enum ELCMRulePhase {

	PRE_PROVISION("PRE_PROVISION"),
	AFTER_ACTIVATION("AFTER_ACTIVATION"),
	SUPERVISION("SUPERVISION"),
	AFTER_DEACTIVATION("AFTER_DEACTIVATION"),
	CREATION("CREATION");
	
	private String value;
	
	ELCMRulePhase(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static ELCMRulePhase getEnum(String value) {
        for(ELCMRulePhase v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
