package io.openslice.sd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import io.openslice.tmf.scm633.model.ServiceSpecification;

/**
 * This model will hold information that will help later on service
 * orchestration. It should be attached to entities that we need to orchestrate
 * in general, like {@link ServiceSpecification}
 * 
 * @author ctranoris
 *
 */
@Entity(name = "ServiceDescriptorAttr")
public class ServiceDescriptorAttr {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	protected String uuid = null;

	private String name;

	private String value;

	public ServiceDescriptorAttr() {

	}

	public ServiceDescriptorAttr(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
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

}
