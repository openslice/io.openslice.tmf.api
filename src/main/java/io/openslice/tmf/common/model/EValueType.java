package io.openslice.tmf.common.model;


public enum EValueType {

	INTEGER("INTEGER"),
	SMALLINT("SMALLINT"),
	lONGINT("LONGINT"),
	FLOAT("FLOAT"),
	BINARY("BINARY"),
	ARRAY("ARRAY"),
	TEXT("TEXT"),
	LONGTEXT("LONGTEXT"),
	ENUM("ENUM"),
	TIMESTAMP("TIMESTAMP");
	
	
	private String value;
	
	EValueType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static EValueType getEnum(String value) {
        for(EValueType v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
