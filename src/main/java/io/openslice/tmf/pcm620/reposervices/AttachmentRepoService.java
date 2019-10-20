package io.openslice.tmf.pcm620.reposervices;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.pcm620.model.Attachment;
import io.openslice.tmf.pcm620.repo.AttachmentRepository;


@Service
public class AttachmentRepoService {


	@Autowired
	AttachmentRepository attachmentRepo;
	
	public Attachment addAttachment(Attachment c) {

		return this.attachmentRepo.save(c);
	}

	public Attachment updateAttachment(@Valid Attachment attachment) {
		return this.attachmentRepo.save( attachment );
	}
}
