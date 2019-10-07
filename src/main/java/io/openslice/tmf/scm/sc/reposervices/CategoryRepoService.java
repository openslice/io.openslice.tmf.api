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
import io.openslice.tmf.scm.model.ServiceCategory;
import io.openslice.tmf.scm.model.ServiceCategoryCreate;
import io.openslice.tmf.scm.model.ServiceCategoryUpdate;
import io.openslice.tmf.scm.model.TimePeriod;
import io.openslice.tmf.scm.sc.repo.CatalogRepository;
import io.openslice.tmf.scm.sc.repo.CategoriesRepository;

@Service
public class CategoryRepoService {


	@Autowired
	CategoriesRepository categsRepo;
	


	@Autowired
	CatalogRepository catalogRepo;
	
	public ServiceCategory addCategory(ServiceCategory c) {

		return this.categsRepo.save( c );
	}

	public ServiceCategory addCategory(@Valid ServiceCategoryCreate serviceCategory) {	
		
		
		ServiceCategory sc = new ServiceCategory() ;
		sc.setName( serviceCategory.getName() );
		sc.setDescription( serviceCategory.getDescription() );
		sc.setIsRoot(serviceCategory.isIsRoot() );
		sc.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		sc.setParentId( serviceCategory.getParentId() );
		if ( serviceCategory.getLifecycleStatus() == null ) {
			sc.setLifecycleStatusEnum( ELifecycle.LAUNCHED );
		} else {
			sc.setLifecycleStatusEnum ( ELifecycle.getEnum( serviceCategory.getLifecycleStatus() ) );
		}
		sc.setVersion( serviceCategory.getVersion());
		TimePeriod tp = new TimePeriod();
		tp.setStartDateTime(OffsetDateTime.now(ZoneOffset.UTC) );
		tp.setEndDateTime(OffsetDateTime.now(ZoneOffset.UTC).plusYears(10) );
		sc.setValidFor( tp );
		
		
		sc = this.categsRepo.save( sc );
		
		
		return sc;
	}

	public List<ServiceCategory> findAll() {
		return (List<ServiceCategory>) this.categsRepo.findAll();
	}

	public ServiceCategory findById(String id) {
		Optional<ServiceCategory> optionalCat = this.categsRepo.findById( id );
		return optionalCat
				.orElse(null);
	}

	public Void deleteById(String id) {
		Optional<ServiceCategory> optionalCat = this.categsRepo.findById( id );
		this.categsRepo.delete( optionalCat.get());
		return null;
		
	}

	public ServiceCategory updateCategory(String id, @Valid ServiceCategoryUpdate serviceCategory) {
		Optional<ServiceCategory> optionalCat = this.categsRepo.findById( id );
		if ( optionalCat == null ) {
			return null;
		}
		
		ServiceCategory sc = optionalCat.get();
		sc.setName( serviceCategory.getName()  );
		sc.setLifecycleStatus( serviceCategory.getLifecycleStatus() );
		sc.setVersion( serviceCategory.getVersion() );
		sc.setLastUpdate( OffsetDateTime.now(ZoneOffset.UTC) );
		TimePeriod tp = new TimePeriod();
		tp.setStartDateTime( serviceCategory.getValidFor().getStartDateTime() );
		tp.setEndDateTime( serviceCategory.getValidFor().getEndDateTime() );
		sc.setValidFor( tp );
		return this.categsRepo.save( sc );
	}

}
