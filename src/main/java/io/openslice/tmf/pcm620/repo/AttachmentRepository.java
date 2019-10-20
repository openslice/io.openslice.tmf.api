package io.openslice.tmf.pcm620.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.openslice.tmf.pcm620.model.Attachment;

@Repository
public interface AttachmentRepository extends PagingAndSortingRepository<Attachment, Long> {

	
	Optional<Attachment> findByUuid(String id);
	


}
