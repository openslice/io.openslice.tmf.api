/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.common.model;


public enum EValueType {

	INTEGER("INTEGER"),
	SMALLINT("SMALLINT"),
	lONGINT("LONGINT"),
	FLOAT("FLOAT"),
	BINARY("BINARY"),
	BOOLEAN("BOOLEAN"),
	ARRAY("ARRAY"),
	SET("SET"),
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
