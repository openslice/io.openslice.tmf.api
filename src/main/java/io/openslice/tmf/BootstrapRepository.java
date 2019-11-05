package io.openslice.tmf;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.EValueType;
import io.openslice.tmf.rcm634.model.LogicalResourceSpec;
import io.openslice.tmf.rcm634.model.ResourceSpecCharacteristic;
import io.openslice.tmf.rcm634.model.ResourceSpecCharacteristicValue;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;
import io.openslice.tmf.scm633.model.ServiceCandidateCreate;
import io.openslice.tmf.scm633.model.ServiceCatalog;
import io.openslice.tmf.scm633.model.ServiceCatalogCreate;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceCategoryCreate;
import io.openslice.tmf.scm633.model.ServiceCategoryRef;
import io.openslice.tmf.scm633.model.ServiceSpecRelationship;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.model.ServiceSpecificationRef;
import io.openslice.tmf.scm633.reposervices.CandidateRepoService;
import io.openslice.tmf.scm633.reposervices.CatalogRepoService;
import io.openslice.tmf.scm633.reposervices.CategoryRepoService;
import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;

/**
 * @author ctranoris
 *
 */
@Service
public class BootstrapRepository {


	private static final boolean ADDGST = true;

	private static final boolean ADDVINNISBT = true;

	@Autowired
	CatalogRepoService catalogRepoService;

	@Autowired
	CategoryRepoService categRepoService;
	
	@Autowired
	CandidateRepoService candidateRepoService;

	@Autowired
	ServiceSpecificationRepoService specRepoService;

	@Autowired
	ResourceSpecificationRepoService resourceSpecRepoService;
	

	@Autowired
	ObjectMapper objectMapper;
	
	@PostConstruct
	public void initRepo() {
		if (this.catalogRepoService.findAll().size() == 0) {
			ServiceCatalogCreate sc = new ServiceCatalogCreate();
			sc.setName("Catalog");
			sc.setDescription("Primary Catalog");
			sc.setVersion("1.0");
			ServiceCatalog scatalog = this.catalogRepoService.addCatalog(sc);

			ServiceCategoryCreate scatCreate = new ServiceCategoryCreate();
			scatCreate.setName("Generic Services");
			scatCreate.setDescription("Generic Services of this catalog");
			scatCreate.setVersion("1.0");
			scatCreate.setIsRoot(true);
			ServiceCategory scategory = this.categRepoService.addCategory(scatCreate);

			scatalog.getCategoryObj().add(scategory);
			scatalog = this.catalogRepoService.updateCatalog(scatalog);
			/**
			 * Add GST
			 */
			if (ADDGST) {
				this.createFirstTimeGSTRepo( scategory );				
			}
			/**
			 * Add VINNI-SB
			 */
			if (ADDVINNISBT) {
				this.createFirstTimeVINNISBTRepo( scategory );
			}
			
			
		} else { //check if we have the latest version of GST
			if (ADDGST) {
				ServiceCategory scategory = this.categRepoService.findByName("Generic Services");
				ServiceSpecification serviceSpecificationObj = this.specRepoService.findByNameAndVersion("GST External", "0.4.0");
				
				if ( ( scategory != null ) &&  ( serviceSpecificationObj == null ))
				{
					this.createFirstTimeGSTRepo( scategory );
				}
			}
			if (ADDVINNISBT) {
				ServiceCategory scategory = this.categRepoService.findByName("Generic Services");
				ServiceSpecification serviceSpecificationObj = this.specRepoService.findByNameAndVersion("VINNI-SB Template", "0.1.0");				
				if ( ( scategory != null ) &&  ( serviceSpecificationObj == null ))
				{
					this.createFirstTimeVINNISBTRepo( scategory );
				}
			}
			
			
		}
	}

	private void createFirstTimeGSTRepo(ServiceCategory scategory) {

		ServiceSpecification serviceSpecificationObj = readFromLocalResource( "gst.json" );
		serviceSpecificationObj = this.specRepoService.addServiceSpecification(serviceSpecificationObj);
		
		ServiceCandidateCreate scand = new ServiceCandidateCreate();
		scand.setName( serviceSpecificationObj.getName());
		ServiceSpecificationRef serviceSpecificationRef = new ServiceSpecificationRef();
		serviceSpecificationRef.setId(serviceSpecificationObj.getId());
		serviceSpecificationRef.setName(serviceSpecificationObj.getName());
		scand.serviceSpecification(serviceSpecificationRef);

		ServiceCategoryRef categoryItem = new ServiceCategoryRef();
		categoryItem.setId(scategory.getId());
		scand.addCategoryItem(categoryItem);

		this.candidateRepoService.addServiceCandidate(scand);
		
	}
	

	public void createFirstTimeVINNISBTRepo( ServiceCategory scategory ) {

		/**
		 * Create the VINNI-SB as Bundle from file
		 */
		ServiceSpecification serviceSpecVinniSB = readFromLocalResource("vinnisb/vinnisb.json");
		serviceSpecVinniSB = this.specRepoService.addServiceSpecification(serviceSpecVinniSB);
		
		/**
		 * Create RFS 
		 * 1: Create Resource Spec NS Topology
		 * 
		 */
		ResourceSpecification resourceNSTopology = new LogicalResourceSpec();
		resourceNSTopology.setName( "NS Topology");
		resourceNSTopology.setVersion( serviceSpecVinniSB.getVersion() );		
		ResourceSpecCharacteristic resourceSpecCharacteristicItem = new ResourceSpecCharacteristic();
		resourceSpecCharacteristicItem.setName("Slice name");
		resourceSpecCharacteristicItem.setDescription("Slice Name on target NFVO");
		resourceSpecCharacteristicItem.setValueType( EValueType.TEXT.getValue() );
		ResourceSpecCharacteristicValue resourceSpecCharacteristicValueItem = new ResourceSpecCharacteristicValue();
		resourceSpecCharacteristicValueItem.setValue( new Any("SLICENAME", "The slice name"));
		resourceSpecCharacteristicItem.addResourceSpecCharacteristicValueItem(resourceSpecCharacteristicValueItem);
		resourceNSTopology.addResourceSpecCharacteristicItem(resourceSpecCharacteristicItem);
		
		resourceNSTopology = resourceSpecRepoService.addResourceSpec( resourceNSTopology );
		
		/**
		 * 2: Create Service Topology related to resourceSpec
		 */
		ServiceSpecification serviceTopology = new ServiceSpecification();
		serviceTopology.setName( "Service Topology");
		ResourceSpecificationRef resourceSpecificationItemRef = new ResourceSpecificationRef();
		resourceSpecificationItemRef.setId( resourceNSTopology.getId() );
		resourceSpecificationItemRef.setName( resourceNSTopology.getName() );
		resourceSpecificationItemRef.setVersion(resourceNSTopology.getVersion() );
		serviceTopology.addResourceSpecificationItem(resourceSpecificationItemRef);
		serviceTopology = this.specRepoService.addServiceSpecification( serviceTopology );
		
		
		ServiceSpecRelationship serviceSpecRelationshipItem  =new ServiceSpecRelationship();
		serviceSpecRelationshipItem.setId( serviceTopology.getId());
		serviceSpecRelationshipItem.setName( serviceTopology.getName() );
		serviceSpecVinniSB.addServiceSpecRelationshipItem(serviceSpecRelationshipItem  );
		serviceSpecVinniSB = this.specRepoService.updateServiceSpecification(serviceSpecVinniSB);
		
		/**
		 * add VINNI-SB Service Spec to Catalog
		 */
		ServiceCandidateCreate scand = new ServiceCandidateCreate();
		scand.setName( serviceSpecVinniSB.getName());
		ServiceSpecificationRef serviceSpecificationRef = new ServiceSpecificationRef();
		serviceSpecificationRef.setId(serviceSpecVinniSB.getId());
		serviceSpecificationRef.setName(serviceSpecVinniSB.getName());
		scand.serviceSpecification(serviceSpecificationRef);

		ServiceCategoryRef categoryItem = new ServiceCategoryRef();
		categoryItem.setId(scategory.getId());
		scand.addCategoryItem(categoryItem);

		this.candidateRepoService.addServiceCandidate(scand);				
	}

	private ServiceSpecification readFromLocalResource(String rname) {
		ServiceSpecification sc;
		try {
			sc = objectMapper.readValue(new ClassPathResource( rname ).getInputStream(), ServiceSpecification.class);
			
			return sc;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}