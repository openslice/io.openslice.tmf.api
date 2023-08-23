package io.openslice.tmf.lcm.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.common.model.BaseEntity;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ctranoris
 * 
 * A LCM RuleSpecification is an entity that describes a LCM rule to apply during the LCM of a service
 *
 */
@Schema(description = "A LCM RuleSpecification is an entity that describes a LCM rule to apply during the LCM of a service.")
@Validated
@Entity(name = "LCMRuleSpec")
@EqualsAndHashCode(callSuper=true)
public class LCMRuleSpecification extends BaseEntity{	


	@JsonProperty("id")
	protected String id = null;
	
	
	@JsonProperty("lcmrulephase")
	protected String lcmrulephase = ELCMRulePhase.PRE_PROVISION.getValue();	

	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST,  CascadeType.DETACH, CascadeType.REFRESH })
	@JsonIgnore
	private Set<ServiceSpecificationRef > serviceSpecs = new HashSet<>();
		

	@Lob
	@Column(name = "LCONTENT", columnDefinition = "LONGTEXT")
	@JsonProperty("content")
	protected String content = null;
	

	@Lob
	@Column(name = "LCODE", columnDefinition = "LONGTEXT")
	@JsonProperty("code")
	protected String code = null;

	@JsonProperty("priority")
	protected int priority = 0;

	/**
	 * @return the id
	 */
	public String getId() {
		if ( uuid != null ) {
			id = uuid;
		} 
		return id;
	}
	
	public void setId(String id) {
		id = uuid;
	}
	

//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("class Entity {\n");
//
//		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
//		sb.append("    href: ").append(toIndentedString(href)).append("\n");
//		sb.append("    description: ").append(toIndentedString(description)).append("\n");
//		sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
//		sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
//		sb.append("    name: ").append(toIndentedString(name)).append("\n");
//		sb.append("    version: ").append(toIndentedString(version)).append("\n");
//		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
//		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
//		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
//		sb.append("    type: ").append(toIndentedString(type)).append("\n");
//		sb.append("}");
//		return sb.toString();
//	}
	
	
	
	/**
	 * List of service categories associated with this catalog
	 * 
	 * @return category
	 **/
	@Schema(description = "List of service specs associated with this rule")
	@Transient
	@JsonProperty("serviceSpecs")
	@Valid
	public Set<ServiceSpecificationRef> getServiceSpecs() {

		return this.serviceSpecs;		
	}
	
	public void addServiceSpecificationRef(ServiceSpecificationRef s) {
		if (!this.serviceSpecs.contains(s) ) {
			this.serviceSpecs.add(s);
		}
		
	}


	
	/**
	 * @param serviceSpecs the serviceSpecs to set
	 */
	public void setServiceSpecs(Set<ServiceSpecificationRef> serviceSpecs) {
		this.serviceSpecs = serviceSpecs;
	}

	public void copyFromObj(BaseEntity be) {
		super.copyFromObj(be);
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


	/**
	 * @return the lcmrulephase
	 */
	public String getLcmrulephase() {
		return lcmrulephase;
	}


	/**
	 * @param lcmrulephase the lcmrulephase to set
	 */
	public void setLcmrulephase(String lcmrulephase) {
		this.lcmrulephase = lcmrulephase;
	}
	
	public void setLcmrulephase(ELCMRulePhase lcmrulephase) {
		this.lcmrulephase = lcmrulephase.getValue();
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}



}
