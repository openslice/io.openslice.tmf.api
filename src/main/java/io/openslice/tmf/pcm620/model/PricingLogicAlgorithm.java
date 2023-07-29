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
package io.openslice.tmf.pcm620.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;

/**
 * The PricingLogicAlgorithm entity represents an instantiation of an interface specification to external rating function (without a modeled bahavior in SID). Some of the parameters of the interface definiition may be already set (such as price per unit) and some may be gathered during the rating process from the event (such as call duration) or from ProductCharacteristicValues (such as assigned bandwidth)
 */
@Schema(description = "The PricingLogicAlgorithm entity represents an instantiation of an interface specification to external rating function (without a modeled bahavior in SID). Some of the parameters of the interface definiition may be already set (such as price per unit) and some may be gathered during the rating process from the event (such as call duration) or from ProductCharacteristicValues (such as assigned bandwidth)")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:15:57.249+03:00")


@Entity
public class PricingLogicAlgorithm  extends BaseEntity {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("plaSpecId")
  private String plaSpecId = null;



  public PricingLogicAlgorithm id(String id) {
    this.id = id;
    return this;
  }

  /**
   * unique id of the PricingLogicAlgorithm
   * @return id
  **/
  @Schema(description = "unique id of the PricingLogicAlgorithm")


  public String getId() {
		if ( uuid != null ) {
			id = uuid;			
		} 
		return id;
  }


  public PricingLogicAlgorithm plaSpecId(String plaSpecId) {
    this.plaSpecId = plaSpecId;
    return this;
  }

  /**
   * id of corresponding PricingLogicAlgorithm specification
   * @return plaSpecId
  **/
  @Schema(description = "id of corresponding PricingLogicAlgorithm specification")


  public String getPlaSpecId() {
    return plaSpecId;
  }

  public void setPlaSpecId(String plaSpecId) {
    this.plaSpecId = plaSpecId;
  }



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PricingLogicAlgorithm pricingLogicAlgorithm = (PricingLogicAlgorithm) o;
    return Objects.equals(this.id, pricingLogicAlgorithm.id) &&
        Objects.equals(this.href, pricingLogicAlgorithm.href) &&
        Objects.equals(this.description, pricingLogicAlgorithm.description) &&
        Objects.equals(this.name, pricingLogicAlgorithm.name) &&
        Objects.equals(this.plaSpecId, pricingLogicAlgorithm.plaSpecId) &&
        Objects.equals(this.validFor, pricingLogicAlgorithm.validFor) &&
        Objects.equals(this.baseType, pricingLogicAlgorithm.baseType) &&
        Objects.equals(this.schemaLocation, pricingLogicAlgorithm.schemaLocation) &&
        Objects.equals(this.type, pricingLogicAlgorithm.type);
  }

//  @Override
//  public int hashCode() {
//    return Objects.hash(id, href, description, name, plaSpecId, validFor, baseType, schemaLocation, type);
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricingLogicAlgorithm {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    plaSpecId: ").append(toIndentedString(plaSpecId)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

