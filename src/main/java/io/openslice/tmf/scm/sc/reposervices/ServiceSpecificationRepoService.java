package io.openslice.tmf.scm.sc.reposervices;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.scm.model.ELifecycle;
import io.openslice.tmf.scm.model.ServiceCatalog;
import io.openslice.tmf.scm.model.ServiceSpecification;
import io.openslice.tmf.scm.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm.model.ServiceSpecification;
import io.openslice.tmf.scm.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm.model.TimePeriod;
import io.openslice.tmf.scm.sc.repo.CatalogRepository;
import io.openslice.tmf.scm.sc.repo.CategoriesRepository;
import io.openslice.tmf.scm.sc.repo.ServiceSpecificationRepository;

@Service
public class ServiceSpecificationRepoService {


	@Autowired
	ServiceSpecificationRepository serviceSpecificationRepo;

	
	public ServiceSpecification addCategory(ServiceSpecification c) {

		return this.serviceSpecificationRepo.save( c );
	}

	public ServiceSpecification addServiceSpecification(@Valid ServiceSpecificationCreate serviceServiceSpecification) {	
		ServiceSpecification serviceSpec = new ServiceSpecification();
		
		return this.serviceSpecificationRepo.save( serviceSpec );
	}

	public List<ServiceSpecification> findAll() {
		return (List<ServiceSpecification>) this.serviceSpecificationRepo.findAll();
	}

	public ServiceSpecification findById(String id) {
		Optional<ServiceSpecification> optionalCat = this.serviceSpecificationRepo.findById( id );
		return optionalCat
				.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<ServiceSpecification> optionalCat = this.serviceSpecificationRepo.findById( id );
		this.serviceSpecificationRepo.delete( optionalCat.get());
		return null;
		
	}

}
