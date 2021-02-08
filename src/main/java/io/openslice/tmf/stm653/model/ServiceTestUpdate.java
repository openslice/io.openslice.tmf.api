package io.openslice.tmf.stm653.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.openslice.tmf.stm653.model.Characteristic;
import io.openslice.tmf.stm653.model.RelatedParty;
import io.openslice.tmf.stm653.model.ServiceRef;
import io.openslice.tmf.stm653.model.ServiceTestSpecificationRef;
import io.openslice.tmf.stm653.model.TestMeasure;
import io.openslice.tmf.stm653.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A service test is an entity that exists for a controlled test invocation on a service. The service  test is executed according to a schedule and contains service test configuration parameters that are to be  applied at execution time, and service test measures that result. Skipped properties: id,href
 */
@ApiModel(description = "A service test is an entity that exists for a controlled test invocation on a service. The service  test is executed according to a schedule and contains service test configuration parameters that are to be  applied at execution time, and service test measures that result. Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-08T11:50:07.226173200+02:00[Europe/Athens]")
public class ServiceTestUpdate   {
  @JsonProperty("description")
  private String description = null;

  @JsonProperty("endDateTime")
  private OffsetDateTime endDateTime = null;

  @JsonProperty("mode")
  private String mode = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("startDateTime")
  private OffsetDateTime startDateTime = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("characteristic")
  @Valid
  private List<Characteristic> characteristic = null;

  @JsonProperty("relatedParty")
  @Valid
  private List<RelatedParty> relatedParty = null;

  @JsonProperty("relatedService")
  private ServiceRef relatedService = null;

  @JsonProperty("testMeasure")
  @Valid
  private List<TestMeasure> testMeasure = null;

  @JsonProperty("testSpecification")
  private ServiceTestSpecificationRef testSpecification = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("@baseType")
  private String _atBaseType = null;

  @JsonProperty("@schemaLocation")
  private String _atSchemaLocation = null;

  @JsonProperty("@type")
  private String _atType = null;

  public ServiceTestUpdate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the service test
   * @return description
  **/
  @ApiModelProperty(value = "Description of the service test")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ServiceTestUpdate endDateTime(OffsetDateTime endDateTime) {
    this.endDateTime = endDateTime;
    return this;
  }

  /**
   * The end date and time of the service test
   * @return endDateTime
  **/
  @ApiModelProperty(value = "The end date and time of the service test")
  
    @Valid
    public OffsetDateTime getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(OffsetDateTime endDateTime) {
    this.endDateTime = endDateTime;
  }

  public ServiceTestUpdate mode(String mode) {
    this.mode = mode;
    return this;
  }

  /**
   * An indication of whether the service test is running in  \"PROACTIVE\" or \"ONDEMAND\" mode
   * @return mode
  **/
  @ApiModelProperty(value = "An indication of whether the service test is running in  \"PROACTIVE\" or \"ONDEMAND\" mode")
  
    public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public ServiceTestUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the service test
   * @return name
  **/
  @ApiModelProperty(value = "The name of the service test")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceTestUpdate startDateTime(OffsetDateTime startDateTime) {
    this.startDateTime = startDateTime;
    return this;
  }

  /**
   * The start date and time of the service test.
   * @return startDateTime
  **/
  @ApiModelProperty(value = "The start date and time of the service test.")
  
    @Valid
    public OffsetDateTime getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(OffsetDateTime startDateTime) {
    this.startDateTime = startDateTime;
  }

  public ServiceTestUpdate state(String state) {
    this.state = state;
    return this;
  }

  /**
   * The actual state the service test is in
   * @return state
  **/
  @ApiModelProperty(value = "The actual state the service test is in")
  
    public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public ServiceTestUpdate characteristic(List<Characteristic> characteristic) {
    this.characteristic = characteristic;
    return this;
  }

  public ServiceTestUpdate addCharacteristicItem(Characteristic characteristicItem) {
    if (this.characteristic == null) {
      this.characteristic = new ArrayList<>();
    }
    this.characteristic.add(characteristicItem);
    return this;
  }

  /**
   * List of characteristics with values that define the test run
   * @return characteristic
  **/
  @ApiModelProperty(value = "List of characteristics with values that define the test run")
      @Valid
    public List<Characteristic> getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(List<Characteristic> characteristic) {
    this.characteristic = characteristic;
  }

  public ServiceTestUpdate relatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public ServiceTestUpdate addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Party related to the test
   * @return relatedParty
  **/
  @ApiModelProperty(value = "Party related to the test")
      @Valid
    public List<RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  public void setRelatedParty(List<RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public ServiceTestUpdate relatedService(ServiceRef relatedService) {
    this.relatedService = relatedService;
    return this;
  }

  /**
   * Get relatedService
   * @return relatedService
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ServiceRef getRelatedService() {
    return relatedService;
  }

  public void setRelatedService(ServiceRef relatedService) {
    this.relatedService = relatedService;
  }

  public ServiceTestUpdate testMeasure(List<TestMeasure> testMeasure) {
    this.testMeasure = testMeasure;
    return this;
  }

  public ServiceTestUpdate addTestMeasureItem(TestMeasure testMeasureItem) {
    if (this.testMeasure == null) {
      this.testMeasure = new ArrayList<>();
    }
    this.testMeasure.add(testMeasureItem);
    return this;
  }

  /**
   * The results of the test in terms of the measured metrics
   * @return testMeasure
  **/
  @ApiModelProperty(value = "The results of the test in terms of the measured metrics")
      @Valid
    public List<TestMeasure> getTestMeasure() {
    return testMeasure;
  }

  public void setTestMeasure(List<TestMeasure> testMeasure) {
    this.testMeasure = testMeasure;
  }

  public ServiceTestUpdate testSpecification(ServiceTestSpecificationRef testSpecification) {
    this.testSpecification = testSpecification;
    return this;
  }

  /**
   * Get testSpecification
   * @return testSpecification
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public ServiceTestSpecificationRef getTestSpecification() {
    return testSpecification;
  }

  public void setTestSpecification(ServiceTestSpecificationRef testSpecification) {
    this.testSpecification = testSpecification;
  }

  public ServiceTestUpdate validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * Get validFor
   * @return validFor
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public ServiceTestUpdate _atBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return _atBaseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")
  
    public String getAtBaseType() {
    return _atBaseType;
  }

  public void setAtBaseType(String _atBaseType) {
    this._atBaseType = _atBaseType;
  }

  public ServiceTestUpdate _atSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return _atSchemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")
  
    public String getAtSchemaLocation() {
    return _atSchemaLocation;
  }

  public void setAtSchemaLocation(String _atSchemaLocation) {
    this._atSchemaLocation = _atSchemaLocation;
  }

  public ServiceTestUpdate _atType(String _atType) {
    this._atType = _atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class Extensible name
   * @return _atType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class Extensible name")
  
    public String getAtType() {
    return _atType;
  }

  public void setAtType(String _atType) {
    this._atType = _atType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceTestUpdate serviceTestUpdate = (ServiceTestUpdate) o;
    return Objects.equals(this.description, serviceTestUpdate.description) &&
        Objects.equals(this.endDateTime, serviceTestUpdate.endDateTime) &&
        Objects.equals(this.mode, serviceTestUpdate.mode) &&
        Objects.equals(this.name, serviceTestUpdate.name) &&
        Objects.equals(this.startDateTime, serviceTestUpdate.startDateTime) &&
        Objects.equals(this.state, serviceTestUpdate.state) &&
        Objects.equals(this.characteristic, serviceTestUpdate.characteristic) &&
        Objects.equals(this.relatedParty, serviceTestUpdate.relatedParty) &&
        Objects.equals(this.relatedService, serviceTestUpdate.relatedService) &&
        Objects.equals(this.testMeasure, serviceTestUpdate.testMeasure) &&
        Objects.equals(this.testSpecification, serviceTestUpdate.testSpecification) &&
        Objects.equals(this.validFor, serviceTestUpdate.validFor) &&
        Objects.equals(this._atBaseType, serviceTestUpdate._atBaseType) &&
        Objects.equals(this._atSchemaLocation, serviceTestUpdate._atSchemaLocation) &&
        Objects.equals(this._atType, serviceTestUpdate._atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, endDateTime, mode, name, startDateTime, state, characteristic, relatedParty, relatedService, testMeasure, testSpecification, validFor, _atBaseType, _atSchemaLocation, _atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceTestUpdate {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    endDateTime: ").append(toIndentedString(endDateTime)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    startDateTime: ").append(toIndentedString(startDateTime)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    relatedService: ").append(toIndentedString(relatedService)).append("\n");
    sb.append("    testMeasure: ").append(toIndentedString(testMeasure)).append("\n");
    sb.append("    testSpecification: ").append(toIndentedString(testSpecification)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    _atBaseType: ").append(toIndentedString(_atBaseType)).append("\n");
    sb.append("    _atSchemaLocation: ").append(toIndentedString(_atSchemaLocation)).append("\n");
    sb.append("    _atType: ").append(toIndentedString(_atType)).append("\n");
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
