package io.openslice.domain.model.kubernetes;

import io.openslice.domain.model.DomainModelDefinition;
import io.openslice.domain.model.ITMFRCM634_ModelTransformer;
import io.openslice.domain.model.ITMFRI639_ModelTransformer;
import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.EValueType;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;
import io.openslice.tmf.ri639.model.ResourceCreate;
import io.openslice.tmf.ri639.model.ResourceOperationalStateType;
import io.openslice.tmf.ri639.model.ResourceStatusType;
import io.openslice.tmf.ri639.model.ResourceUpdate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ctranoris
 */
@Getter
@Setter
public class KubernetesContextDefinition 
	extends DomainModelDefinition 
	implements ITMFRCM634_ModelTransformer,	ITMFRI639_ModelTransformer {

	
	public static final String OSL_KUBD_RSPEC_NAME = "kubernetes-context-definition.openslice.io";
	public static final String OSL_KUBD_RSPEC_VERSION = "0.0.1";
	public static final String OSL_KUBD_RSPEC_CATEGORY = "KubernetesContextDefinition";
	public static final String OSL_KUBD_RESOURCE_CATEGORY = "KubernetesContextDefinition";
	public static final String OSL_KUBD_RSPEC_TYPE = "LogicalResourceSpecification";
	public static final String OSL_KUBD_RSPEC_DESCRIPTION = "This Specification is used to describe a KubernetesClient";	

	private String osl_KUBD_SPEC_UUID = null; //this is assigned by the system through the DB for a specific instance
	
	//properties of an instance
	private String masterURL;
	private String currentContextName;
	private String currentContextCluster;
	private String currentContextUser;
	private String clusterVersion;
	

    @Builder
	public KubernetesContextDefinition(String osl_KUBD_SPEC_UUID, String uuid, String name, String version, String description, String category,
			String masterURL, String currentContextName, String currentContextCluster, String currentContextUser,
			String clusterVersion) {
		super(uuid, name, version, description, category);
		this.osl_KUBD_SPEC_UUID = osl_KUBD_SPEC_UUID;
		this.masterURL = masterURL;
		this.currentContextName = currentContextName;
		this.currentContextCluster = currentContextCluster;
		this.currentContextUser = currentContextUser;
		this.clusterVersion = clusterVersion;
	}

	
	@Override
	public ResourceSpecificationCreate toRSpecCreate_InitRepo() {
		ResourceSpecificationCreate rsc = this.toRSpecCreate();
		rsc.setName( OSL_KUBD_RSPEC_NAME );
		rsc.setVersion( OSL_KUBD_RSPEC_VERSION );
		rsc.setCategory( OSL_KUBD_RSPEC_CATEGORY );
		rsc.setDescription( OSL_KUBD_RSPEC_DESCRIPTION );
		rsc.setType( OSL_KUBD_RSPEC_TYPE );
		rsc.setLifecycleStatus( ELifecycle.ACTIVE.getValue() );

		return rsc;
		
	}
	
	@Override
	public ResourceSpecificationCreate toRSpecCreate() {
		ResourceSpecificationCreate rsc = new ResourceSpecificationCreate();
		rsc.setName( this.name );
		rsc.setVersion( this.version );
		rsc.setCategory( OSL_KUBD_RSPEC_CATEGORY );
		rsc.setDescription( this.description );
		rsc.setType( OSL_KUBD_RSPEC_TYPE );
		rsc.setLifecycleStatus( ELifecycle.ACTIVE.getValue() );
		rsc.addResourceSpecificationCharacteristicItemShort( "masterURL", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "resourceVersion", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "currentContextName", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "currentContextCluster", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "currentContextUser", "", EValueType.TEXT.getValue(), false);
		rsc.addResourceSpecificationCharacteristicItemShort( "clusterVersion", "", EValueType.TEXT.getValue(), false);		
		return rsc;
		
	}
	
	@Override
	public ResourceSpecificationUpdate toRSpecUpdate() {
		return this.toRSpecCreate();
	}
	
	/* we care only for the ID of the specification from the stored model. The definition will be static
	 * (non-Javadoc)
	 * @see io.openslice.domain.model.ITMFRCM634_ModelTransformer#fromRSpec(io.openslice.tmf.rcm634.model.ResourceSpecification)
	 */
	@Override
	public KubernetesContextDefinition fromRSpec(ResourceSpecification rSpec) {
		osl_KUBD_SPEC_UUID = rSpec.getUuid();
		return this;
	}
	
	
	/* 
	 * returns Null if OSL_KUBD_RSPEC_UUID is not initialized
	 * (non-Javadoc)
	 * @see io.openslice.domain.model.ITMFRI639_ModelTransformer#toResourceCreate()
	 */
	@Override
	public ResourceCreate toResourceCreate() throws Exception {
		if (this.osl_KUBD_SPEC_UUID == null) {
			throw new Exception( "osl_UUID is null. Resource cannot be created without referring a Resource specification" );

		}
		
		ResourceSpecificationRef rSpecRef = new ResourceSpecificationRef();
		rSpecRef.setId( this.osl_KUBD_SPEC_UUID  );
		rSpecRef.setName( OSL_KUBD_RSPEC_NAME );
		rSpecRef.setVersion( OSL_KUBD_RSPEC_VERSION );
		
		ResourceCreate rs = new ResourceCreate();
		rs.setName( this.name );
		rs.setResourceStatus( ResourceStatusType.AVAILABLE );
		rs.setOperationalState( ResourceOperationalStateType.ENABLE);
		rs.setCategory( OSL_KUBD_RESOURCE_CATEGORY );
		rs.setResourceSpecification(rSpecRef);
		rs.resourceVersion( this.clusterVersion );

		rs.addResourceCharacteristicItemShort("masterUrl", this.masterURL, EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("currentContextName", this.currentContextName  , EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("currentContextCluster", this.currentContextCluster   , EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("currentContextUser", this.currentContextUser  , EValueType.TEXT.getValue());
		rs.addResourceCharacteristicItemShort("clusterVersion", this.clusterVersion  , EValueType.TEXT.getValue());
		
		
		
		
		return rs;
	}
	
	@Override
	public ResourceUpdate toResourceUpdate() throws Exception {
		return this.toResourceCreate();
	}

	

	
}
