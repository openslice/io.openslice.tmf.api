package io.openslice.sd.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.swagger.annotations.ApiModel;

/**
 * This model will hold information that will help later on service orchestration.
 * It should be attached to entities that we need to orchestrate in general, like {@link ServiceSpecification} 
 * 
 * @author ctranoris
 *
 */
@ApiModel(description = "This model will hold information that will help later on service orchestration.")
@Validated
@Entity(name = "ServiceDescriptor")
public class ServiceDescriptor {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	protected String uuid = null;


	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	Set<ServiceDescriptorAttr> metadata = new HashSet<>();
	
	
	/**
	 * references the root entity ID of this SD 
	 */
	private String rootEntityID;

	/**
	 * references the root entity ID of this SD 
	 */
	private String rootEntityType;
	
	
	public ServiceDescriptor() {

	}


	/**
	 * @return the metadata
	 */
	public Set<ServiceDescriptorAttr> getMetadata() {
		return metadata;
	}


	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(Set<ServiceDescriptorAttr> metadata) {
		this.metadata = metadata;
	}


	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}


	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	/**
	 * @return the rootEntityID
	 */
	public String getRootEntityID() {
		return rootEntityID;
	}


	/**
	 * @param rootEntityID the rootEntityID to set
	 */
	public void setRootEntityID(String rootEntityID) {
		this.rootEntityID = rootEntityID;
	}


	/**
	 * @return the rootEntityType
	 */
	public String getRootEntityType() {
		return rootEntityType;
	}


	/**
	 * @param rootEntityType the rootEntityType to set
	 */
	public void setRootEntityType(String rootEntityType) {
		this.rootEntityType = rootEntityType;
	}
	
	
	
}
